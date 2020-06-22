
package br.com.tmdev.azure.face.api.response.detect;

import java.util.List;

public class FaceAttributes {

    private Makeup makeup;
    private FacialHair facialHair;
    private String gender;
    private List<Object> accessories = null;
    private Blur blur;
    private HeadPose headPose;
    private Integer smile;
    private String glasses;
    private Hair hair;
    private Emotion emotion;
    private Exposure exposure;
    private Occlusion occlusion;
    private Noise noise;
    private Double age;

    public Makeup getMakeup() {
        return makeup;
    }

    public void setMakeup(Makeup makeup) {
        this.makeup = makeup;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public void setFacialHair(FacialHair facialHair) {
        this.facialHair = facialHair;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Object> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Object> accessories) {
        this.accessories = accessories;
    }

    public Blur getBlur() {
        return blur;
    }

    public void setBlur(Blur blur) {
        this.blur = blur;
    }

    public HeadPose getHeadPose() {
        return headPose;
    }

    public void setHeadPose(HeadPose headPose) {
        this.headPose = headPose;
    }

    public Integer getSmile() {
        return smile;
    }

    public void setSmile(Integer smile) {
        this.smile = smile;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Exposure getExposure() {
        return exposure;
    }

    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }

    public Occlusion getOcclusion() {
        return occlusion;
    }

    public void setOcclusion(Occlusion occlusion) {
        this.occlusion = occlusion;
    }

    public Noise getNoise() {
        return noise;
    }

    public void setNoise(Noise noise) {
        this.noise = noise;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

}
