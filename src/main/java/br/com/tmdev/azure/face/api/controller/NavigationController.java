package br.com.tmdev.azure.face.api.controller;

import br.com.tmdev.azure.face.api.request.detect.FaceDetectRequest;
import br.com.tmdev.azure.face.api.request.face.FaceRequest;
import br.com.tmdev.azure.face.api.request.identify.IdentifyRequest;
import br.com.tmdev.azure.face.api.request.person.PersonRequest;
import br.com.tmdev.azure.face.api.request.persongroup.PersonGroupRequest;
import br.com.tmdev.azure.face.api.response.detect.FaceDetectResponse;
import br.com.tmdev.azure.face.api.response.identify.IdentifyResponse;
import br.com.tmdev.azure.face.api.response.person.PersonResponse;
import br.com.tmdev.azure.face.api.response.persongroup.PersonGroupResponse;
import br.com.tmdev.azure.face.api.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NavigationController {

    @Autowired
    private FaceService faceService;

    @GetMapping("/")
    public String index() {
        return "redirect:/addPersonGroupPage";
    }

    @GetMapping("/addPersonGroupPage")
    public String addPersonGroupPage(Model model) {
        model.addAttribute("personGroups", faceService.getPersonGroups());
        model.addAttribute("personGroupRequest", new PersonGroupRequest());
        return "add-person-group";
    }

    @PostMapping("/addPersonGroup")
    public String addPersonGroup(PersonGroupRequest personGroupRequest) {
        faceService.addPersonGroup(personGroupRequest);
        return "redirect:/addPersonGroupPage";
    }

    @GetMapping("/addPersonPage")
    public String addPersonPage(Model model) {
        List<PersonGroupResponse> personGroups = faceService.getPersonGroups();
        model.addAttribute("personGroups", personGroups);

        List<PersonResponse> personResponseList = new ArrayList<>();

        personGroups.forEach(i -> {
            List<PersonResponse> personList = faceService.getPersonList(i.getPersonGroupId());
            personList.forEach(y -> {
                y.setPersonGroup(i.getName());
                y.setPersonGroupId(i.getPersonGroupId());
                personResponseList.add(y);
            });
        });

        model.addAttribute("personList", personResponseList);

        model.addAttribute("personRequest", new PersonRequest());
        return "add-person";
    }

    @PostMapping("/addPerson")
    public String addPerson(PersonRequest personRequest) {
        faceService.addPerson(personRequest);
        return "redirect:/addPersonPage";
    }

    @PostMapping("/deletePerson/{personGroupId}/{personId}")
    public String deletePerson(@PathVariable String personGroupId, @PathVariable String personId) {
        faceService.deletePerson(personGroupId, personId);
        faceService.trainPersonGroup(personGroupId);
        return "redirect:/addPersonPage";
    }

    @PostMapping("/deletePersonGroup/{personGroupId}")
    public String deletePersonGroup(@PathVariable String personGroupId) {
        faceService.deletePersonGroup(personGroupId);
        return "redirect:/addPersonGroupPage";
    }

    @GetMapping("/addFacePage/{personGroupId}/{personId}")
    public String addFacePage(@PathVariable String personGroupId, @PathVariable String personId, Model model) {
        List<PersonResponse> personList = faceService.getPersonList(personGroupId);
        FaceRequest faceRequest = new FaceRequest();
        faceRequest.setPersonGroupId(personGroupId);
        faceRequest.setPersonId(personId);
        model.addAttribute("faceRequest", faceRequest);
        return "add-face";
    }

    @PostMapping("/addFace")
    public String addFace(FaceRequest faceRequest) {
        System.out.println("faceRequest person id = " + faceRequest.getPersonId());
        System.out.println("faceRequest person group id = " + faceRequest.getPersonGroupId());
        faceService.addFace(faceRequest);
        return "redirect:/addPersonPage";
    }

    @GetMapping("/identifyPage")
    public String identifyPage(Model model) {
        model.addAttribute("personGroups", faceService.getPersonGroups());
        model.addAttribute("faceRequest", new FaceRequest());
        return "identify";
    }

    @PostMapping("/identify")
    public String identify(FaceRequest faceRequest, Model model) {
        FaceDetectRequest faceDetectRequest = new FaceDetectRequest();
        faceDetectRequest.setUrl(faceRequest.getUrl());

        List<FaceDetectResponse> detectResponse = faceService.detect(
                true,
                false,
                null,
                null,
                false,
                null,
                faceDetectRequest);

        IdentifyRequest identifyRequest = new IdentifyRequest();
        identifyRequest.setPersonGroupId(faceRequest.getPersonGroupId());
        identifyRequest.setFaceIds(detectResponse.stream().map(i -> i.getFaceId()).collect(Collectors.toList()));
        List<IdentifyResponse> identifyResponse = faceService.identity(identifyRequest);

        List<PersonResponse> personsResponse = new ArrayList<>();

        identifyResponse.forEach(i -> {
            i.getCandidates().forEach(y -> {
                PersonRequest person = new PersonRequest();
                person.setPersonId(y.getPersonId());
                person.setPersonGroupId(faceRequest.getPersonGroupId());
                PersonResponse personResponse = faceService.getPerson(person);
                personResponse.setIdentifyConfidenceResult(y.getConfidence());
                personsResponse.add(personResponse);
            });
        });

        model.addAttribute("personsResponse", personsResponse);
        return "identify-result";
    }

    @GetMapping("/trainPersonGroup/{personGroupId}")
    public String trainPersonGroup(@PathVariable String personGroupId) {
        faceService.trainPersonGroup(personGroupId);
        return "redirect:/addPersonGroupPage";
    }
}
