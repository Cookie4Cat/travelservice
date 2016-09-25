package edu.ynu.travel.message.scenic;

import edu.ynu.travel.entity.scenic.ScenicEntity;

import java.util.List;


public class ScenicList {
    private List<ScenicEntity> scenicEntities;
    private int count;

    public ScenicList(int count, List<ScenicEntity> scenicEntities) {
        this.count = count;
        this.scenicEntities = scenicEntities;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ScenicEntity> getScenicEntities() {
        return scenicEntities;
    }

    public void setScenicEntities(List<ScenicEntity> scenicEntities) {
        this.scenicEntities = scenicEntities;
    }
}
