
package br.com.tmdev.azure.face.api.response.detect;


public class Exposure {

    private Double value;
    private String exposureLevel;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getExposureLevel() {
        return exposureLevel;
    }

    public void setExposureLevel(String exposureLevel) {
        this.exposureLevel = exposureLevel;
    }

}
