package br.com.tmdev.azure.face.api.response.person;

import java.util.List;

public class PersonResponse {

    private String personId;

    private String name;

    private String userData;

    private List<String> persistedFaceIds;

    private String personGroup;

    private String personGroupId;

    private Double identifyConfidenceResult;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public List<String> getPersistedFaceIds() {
        return persistedFaceIds;
    }

    public void setPersistedFaceIds(List<String> persistedFaceIds) {
        this.persistedFaceIds = persistedFaceIds;
    }

    public String getPersonGroup() {
        return personGroup;
    }

    public void setPersonGroup(String personGroup) {
        this.personGroup = personGroup;
    }

    public String getPersonGroupId() {
        return personGroupId;
    }

    public void setPersonGroupId(String personGroupId) {
        this.personGroupId = personGroupId;
    }

    public Double getIdentifyConfidenceResult() {
        return identifyConfidenceResult;
    }

    public void setIdentifyConfidenceResult(Double identifyConfidenceResult) {
        this.identifyConfidenceResult = identifyConfidenceResult;
    }
}
