package br.com.tmdev.azure.face.api.request.persongroup;

public class PersonGroupRequest {

    private String name;

    private String userData;

    private String recognitionModel;

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

    public String getRecognitionModel() {
        return recognitionModel;
    }

    public void setRecognitionModel(String recognitionModel) {
        this.recognitionModel = recognitionModel;
    }
}
