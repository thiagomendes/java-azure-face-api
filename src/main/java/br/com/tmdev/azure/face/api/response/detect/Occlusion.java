
package br.com.tmdev.azure.face.api.response.detect;


public class Occlusion {

    private Boolean eyeOccluded;
    private Boolean mouthOccluded;
    private Boolean foreheadOccluded;

    public Boolean getEyeOccluded() {
        return eyeOccluded;
    }

    public void setEyeOccluded(Boolean eyeOccluded) {
        this.eyeOccluded = eyeOccluded;
    }

    public Boolean getMouthOccluded() {
        return mouthOccluded;
    }

    public void setMouthOccluded(Boolean mouthOccluded) {
        this.mouthOccluded = mouthOccluded;
    }

    public Boolean getForeheadOccluded() {
        return foreheadOccluded;
    }

    public void setForeheadOccluded(Boolean foreheadOccluded) {
        this.foreheadOccluded = foreheadOccluded;
    }

}
