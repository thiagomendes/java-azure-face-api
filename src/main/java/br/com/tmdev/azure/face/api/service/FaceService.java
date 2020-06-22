package br.com.tmdev.azure.face.api.service;

import br.com.tmdev.azure.face.api.client.FaceAzureClient;
import br.com.tmdev.azure.face.api.request.detect.FaceDetectRequest;
import br.com.tmdev.azure.face.api.request.face.FaceRequest;
import br.com.tmdev.azure.face.api.request.identify.IdentifyRequest;
import br.com.tmdev.azure.face.api.request.person.PersonRequest;
import br.com.tmdev.azure.face.api.request.persongroup.PersonGroupRequest;
import br.com.tmdev.azure.face.api.response.detect.FaceDetectResponse;
import br.com.tmdev.azure.face.api.response.identify.IdentifyResponse;
import br.com.tmdev.azure.face.api.response.person.PersonResponse;
import br.com.tmdev.azure.face.api.response.persongroup.PersonGroupResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceService {

    private final Logger LOG = LoggerFactory.getLogger(FaceService.class);

    @Autowired
    private FaceAzureClient faceAzureClient;

    @Value("${azure.face.key}")
    private String azureFaceToken;

    @CacheEvict(cacheNames = "getPersonListByPersonGroupId", allEntries = true)
    public void addPerson(PersonRequest personRequest) {

        faceAzureClient.addPerson(
                azureFaceToken,
                personRequest.getPersonGroupId(),
                personRequest);
    }

    @Cacheable("getPersonGroups")
    public List<PersonGroupResponse> getPersonGroups() {
        LOG.info("init getPersonGroups");
        return faceAzureClient.getPersonGroups(azureFaceToken);
    }

    @CacheEvict(cacheNames = "getPersonGroups", allEntries = true)
    public void addPersonGroup(PersonGroupRequest personGroupRequest) {

        String personGroupId = personGroupRequest.getName().toLowerCase().replaceAll("\\s", "");

        faceAzureClient.addPersonGroup(
                azureFaceToken,
                personGroupId,
                personGroupRequest);
    }

    public List<FaceDetectResponse> detect(
            boolean returnFaceId,
            boolean returnFaceLandmarks,
            String returnFaceAttributes,
            String recognitionModel,
            boolean returnRecognitionModel,
            String detectionModel,
            FaceDetectRequest faceDetectRequest) {

        return faceAzureClient.detect(
                returnFaceId,
                returnFaceLandmarks,
                returnFaceAttributes,
                recognitionModel,
                returnRecognitionModel,
                detectionModel,
                azureFaceToken,
                faceDetectRequest);
    }

    @Cacheable("getPersonListByPersonGroupId")
    public List<PersonResponse> getPersonList(String personGroupId) {
        LOG.info("init getPersonListByPersonGroupId");
        return faceAzureClient.getPersonList(
                azureFaceToken,
                personGroupId);
    }

    @CacheEvict(cacheNames = "getPersonListByPersonGroupId", allEntries = true)
    public void deletePerson(String personGroupId, String personId) {
        faceAzureClient.deletePerson(
                azureFaceToken,
                personGroupId,
                personId);
    }

    @CacheEvict(cacheNames = "getPersonGroups", allEntries = true)
    public void deletePersonGroup(String personGroupId) {
        faceAzureClient.deletePersonGroup(
                azureFaceToken,
                personGroupId);
    }

    @CacheEvict(cacheNames = "getPersonListByPersonGroupId", allEntries = true)
    public void addFace(FaceRequest faceRequest) {
        faceAzureClient.addFace(
                azureFaceToken,
                faceRequest.getPersonGroupId(),
                faceRequest.getPersonId(),
                faceRequest);
    }

    public List<IdentifyResponse> identity(IdentifyRequest identifyRequest) {
        return faceAzureClient.identify(
                azureFaceToken,
                identifyRequest);
    }

    public PersonResponse getPerson(PersonRequest personRequest) {
        return faceAzureClient.getPerson(
                azureFaceToken,
                personRequest.getPersonGroupId(),
                personRequest.getPersonId());
    }

    public void trainPersonGroup(String personGroupId) {
        faceAzureClient.trainPersonGroup(
                azureFaceToken,
                "",
                personGroupId);
    }
}
