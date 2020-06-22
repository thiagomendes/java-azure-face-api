
package br.com.tmdev.azure.face.api.response.detect;


public class HairColor {

    private String color;
    private Double confidence;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

}
