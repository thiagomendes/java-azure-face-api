
package br.com.tmdev.azure.face.api.response.detect;


public class Blur {

    private String blurLevel;
    private Double value;

    public String getBlurLevel() {
        return blurLevel;
    }

    public void setBlurLevel(String blurLevel) {
        this.blurLevel = blurLevel;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
