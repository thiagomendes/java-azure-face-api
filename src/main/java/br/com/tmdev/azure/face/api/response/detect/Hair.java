
package br.com.tmdev.azure.face.api.response.detect;

import java.util.List;

public class Hair {

    private Integer bald;
    private Boolean invisible;
    private List<HairColor> hairColor = null;

    public Integer getBald() {
        return bald;
    }

    public void setBald(Integer bald) {
        this.bald = bald;
    }

    public Boolean getInvisible() {
        return invisible;
    }

    public void setInvisible(Boolean invisible) {
        this.invisible = invisible;
    }

    public List<HairColor> getHairColor() {
        return hairColor;
    }

    public void setHairColor(List<HairColor> hairColor) {
        this.hairColor = hairColor;
    }

}
