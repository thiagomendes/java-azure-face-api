
package br.com.tmdev.azure.face.api.response.detect;


public class Makeup {

    private Boolean eyeMakeup;
    private Boolean lipMakeup;

    public Boolean getEyeMakeup() {
        return eyeMakeup;
    }

    public void setEyeMakeup(Boolean eyeMakeup) {
        this.eyeMakeup = eyeMakeup;
    }

    public Boolean getLipMakeup() {
        return lipMakeup;
    }

    public void setLipMakeup(Boolean lipMakeup) {
        this.lipMakeup = lipMakeup;
    }

}
