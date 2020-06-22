package br.com.tmdev.azure.face.api.client;

import br.com.tmdev.azure.face.api.request.detect.FaceDetectRequest;
import br.com.tmdev.azure.face.api.request.face.FaceRequest;
import br.com.tmdev.azure.face.api.request.identify.IdentifyRequest;
import br.com.tmdev.azure.face.api.request.person.PersonRequest;
import br.com.tmdev.azure.face.api.request.persongroup.PersonGroupRequest;
import br.com.tmdev.azure.face.api.response.detect.FaceDetectResponse;
import br.com.tmdev.azure.face.api.response.face.FaceResponse;
import br.com.tmdev.azure.face.api.response.identify.IdentifyResponse;
import br.com.tmdev.azure.face.api.response.person.PersonResponse;
import br.com.tmdev.azure.face.api.response.persongroup.PersonGroupResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "faceAzureClient", url = "${azure.face.endpoint}")
public interface FaceAzureClient {

    public static final String AZURE_TOKEN_HEADER = "Ocp-Apim-Subscription-Key";

    @RequestMapping(method = RequestMethod.POST, value = "/face/v1.0/detect")
    List<FaceDetectResponse> detect(
            @RequestParam boolean returnFaceId,
            @RequestParam boolean returnFaceLandmarks,
            @RequestParam String returnFaceAttributes,
            @RequestParam String recognitionModel,
            @RequestParam boolean returnRecognitionModel,
            @RequestParam String detectionModel,
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @RequestBody FaceDetectRequest faceDetectRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "/face/v1.0/persongroups/{personGroupId}")
    Void addPersonGroup(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId,
            @RequestBody PersonGroupRequest personGroupRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/face/v1.0/persongroups")
    List<PersonGroupResponse> getPersonGroups(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken);

    @RequestMapping(method = RequestMethod.GET, value = "/face/v1.0/persongroups/{personGroupId}/persons")
    PersonResponse addPerson(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId,
            @RequestBody PersonRequest personRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/face/v1.0/persongroups/{personGroupId}/persons")
    List<PersonResponse> getPersonList(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/face/v1.0/persongroups/{personGroupId}/persons/{personId}")
    Void deletePerson(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId,
            @PathVariable String personId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/face/v1.0/persongroups/{personGroupId}")
    Void deletePersonGroup(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId);

    @RequestMapping(method = RequestMethod.POST, value = "/face/v1.0/persongroups/{personGroupId}/persons/{personId}/persistedFaces")
    FaceResponse addFace(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId,
            @PathVariable String personId,
            @RequestBody FaceRequest faceRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/face/v1.0/identify")
    List<IdentifyResponse> identify(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @RequestBody IdentifyRequest identifyRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/face/v1.0/persongroups/{personGroupId}/persons/{personId}")
    PersonResponse getPerson(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @PathVariable String personGroupId,
            @PathVariable String personId);

    @RequestMapping(method = RequestMethod.POST, value = "/face/v1.0/persongroups/{personGroupId}/train")
    Void trainPersonGroup(
            @RequestHeader(AZURE_TOKEN_HEADER) String azureFaceToken,
            @RequestBody String body,
            @PathVariable String personGroupId);
}