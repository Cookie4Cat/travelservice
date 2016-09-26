package edu.ynu.travel.message.ent;


import edu.ynu.travel.entity.ent.PerformEntity;

import java.util.List;

public class PerformList {
    private List<PerformEntity> performs;
    private int count;

    public PerformList(int count, List<PerformEntity> performs) {
        this.count = count;
        this.performs = performs;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PerformEntity> getPerforms() {
        return performs;
    }

    public void setPerforms(List<PerformEntity> performs) {
        this.performs = performs;
    }
}
