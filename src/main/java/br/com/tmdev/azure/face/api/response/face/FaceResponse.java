package br.com.tmdev.azure.face.api.response.face;

public class FaceResponse {

    private String persistedFaceId;

    public String getPersistedFaceId() {
        return persistedFaceId;
    }

    public void setPersistedFaceId(String persistedFaceId) {
        this.persistedFaceId = persistedFaceId;
    }
}
