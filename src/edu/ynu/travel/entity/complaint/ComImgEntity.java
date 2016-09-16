package edu.ynu.travel.entity.complaint;

public class ComImgEntity {

    private Integer id;

    private Integer comId;

    private String imageUrl;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getComId() {
        return comId;
    }


    public void setComId(Integer comId) {
        this.comId = comId;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
}