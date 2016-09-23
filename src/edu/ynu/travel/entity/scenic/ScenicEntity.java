package edu.ynu.travel.entity.scenic;

public class ScenicEntity {

    private Integer sid;

    private String scenicName;

    private String city;

    private String btnText;

    private String shortDesc;

    private String scenicLevel;

    private String scenicPrice;

    private String scenicType;

    private String scenicSite;

    private String scenicArea;

    private String scenicDescription;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName == null ? null : scenicName.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText == null ? null : btnText.trim();
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc == null ? null : shortDesc.trim();
    }

    public String getScenicLevel() {
        return scenicLevel;
    }

    public void setScenicLevel(String scenicLevel) {
        this.scenicLevel = scenicLevel == null ? null : scenicLevel.trim();
    }

    public String getScenicPrice() {
        return scenicPrice;
    }

    public void setScenicPrice(String scenicPrice) {
        this.scenicPrice = scenicPrice == null ? null : scenicPrice.trim();
    }

    public String getScenicType() {
        return scenicType;
    }

    public void setScenicType(String scenicType) {
        this.scenicType = scenicType == null ? null : scenicType.trim();
    }

    public String getScenicSite() {
        return scenicSite;
    }

    public void setScenicSite(String scenicSite) {
        this.scenicSite = scenicSite == null ? null : scenicSite.trim();
    }

    public String getScenicArea() {
        return scenicArea;
    }

    public void setScenicArea(String scenicArea) {
        this.scenicArea = scenicArea == null ? null : scenicArea.trim();
    }

    public String getScenicDescription() {
        return scenicDescription;
    }

    public void setScenicDescription(String scenicDescription) {
        this.scenicDescription = scenicDescription == null ? null : scenicDescription.trim();
    }
}