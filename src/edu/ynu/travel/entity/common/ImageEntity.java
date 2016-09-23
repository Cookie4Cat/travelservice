package edu.ynu.travel.entity.common;

public class ImageEntity {

    private Integer id;

    private Integer foreignId;

    private String url;

    private String title;

    private String model;

    private String description;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getForeignId() {
        return foreignId;
    }


    public void setForeignId(Integer foreignId) {
        this.foreignId = foreignId;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}