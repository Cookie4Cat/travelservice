package edu.ynu.travel.entity.ent;

import java.util.Date;

public class PerformEntity {

    private Integer id;

    private Integer scenicId;

    private String address;

    private String content;

    private String name;

    private String timeFrame;


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


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }
}