package br.com.tmdev.azure.face.api.response.identify;

public class Candidate {

    private String personId;

    private Double confidence;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
