package br.com.tmdev.azure.face.api.response.identify;

import java.util.List;

public class IdentifyResponse {

    private String faceId;

    private List<Candidate> candidates;

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}
