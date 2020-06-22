
package br.com.tmdev.azure.face.api.response.detect;


public class Emotion {

    private Integer contempt;
    private Double surprise;
    private Integer happiness;
    private Double neutral;
    private Double sadness;
    private Integer disgust;
    private Integer anger;
    private Integer fear;

    public Integer getContempt() {
        return contempt;
    }

    public void setContempt(Integer contempt) {
        this.contempt = contempt;
    }

    public Double getSurprise() {
        return surprise;
    }

    public void setSurprise(Double surprise) {
        this.surprise = surprise;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public Double getSadness() {
        return sadness;
    }

    public void setSadness(Double sadness) {
        this.sadness = sadness;
    }

    public Integer getDisgust() {
        return disgust;
    }

    public void setDisgust(Integer disgust) {
        this.disgust = disgust;
    }

    public Integer getAnger() {
        return anger;
    }

    public void setAnger(Integer anger) {
        this.anger = anger;
    }

    public Integer getFear() {
        return fear;
    }

    public void setFear(Integer fear) {
        this.fear = fear;
    }

}
