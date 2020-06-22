
package br.com.tmdev.azure.face.api.response.detect;


public class FacialHair {

    private Integer sideburns;
    private Integer beard;
    private Integer moustache;

    public Integer getSideburns() {
        return sideburns;
    }

    public void setSideburns(Integer sideburns) {
        this.sideburns = sideburns;
    }

    public Integer getBeard() {
        return beard;
    }

    public void setBeard(Integer beard) {
        this.beard = beard;
    }

    public Integer getMoustache() {
        return moustache;
    }

    public void setMoustache(Integer moustache) {
        this.moustache = moustache;
    }

}
