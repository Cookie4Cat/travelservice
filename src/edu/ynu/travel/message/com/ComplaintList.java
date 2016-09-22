package edu.ynu.travel.message.com;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ComplaintList {
    private List<ComplaintEntity> complaints;
    private int count;

    public ComplaintList(List<ComplaintEntity> complaints, int count) {
        this.complaints = complaints;
        this.count = count;
    }

    public List<ComplaintEntity> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<ComplaintEntity> complaints) {
        this.complaints = complaints;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
