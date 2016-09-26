package edu.ynu.travel.entity.canteen;

public class CanteenEntity {

    private Integer id;


    private Integer scenicId;


    private String name;


    private String type;


    private String price;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getScenicId() {
        return scenicId;
    }


    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}