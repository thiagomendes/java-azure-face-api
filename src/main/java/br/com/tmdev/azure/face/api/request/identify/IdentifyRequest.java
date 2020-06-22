package br.com.tmdev.azure.face.api.request.identify;

import java.util.List;

public class IdentifyRequest {

    private List<String> faceIds;

    private String personGroupId;

    private String largePersonGroupId;

    private Integer maxNumOfCandidatesReturned;

    private Double confidenceThreshold;

    public List<String> getFaceIds() {
        return faceIds;
    }

    public void setFaceIds(List<String> faceIds) {
        this.faceIds = faceIds;
    }

    public String getPersonGroupId() {
        return personGroupId;
    }

    public void setPersonGroupId(String personGroupId) {
        this.personGroupId = personGroupId;
    }

    public String getLargePersonGroupId() {
        return largePersonGroupId;
    }

    public void setLargePersonGroupId(String largePersonGroupId) {
        this.largePersonGroupId = largePersonGroupId;
    }

    public Integer getMaxNumOfCandidatesReturned() {
        return maxNumOfCandidatesReturned;
    }

    public void setMaxNumOfCandidatesReturned(Integer maxNumOfCandidatesReturned) {
        this.maxNumOfCandidatesReturned = maxNumOfCandidatesReturned;
    }

    public Double getConfidenceThreshold() {
        return confidenceThreshold;
    }

    public void setConfidenceThreshold(Double confidenceThreshold) {
        this.confidenceThreshold = confidenceThreshold;
    }
}
