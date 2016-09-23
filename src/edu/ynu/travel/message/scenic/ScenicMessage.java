package edu.ynu.travel.message.scenic;

import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.scenic.ScenicEntity;

import java.util.List;



public class ScenicMessage extends ScenicEntity{
    private List<ImageEntity> Imgs;

    public List<ImageEntity> getImgs() {
        return Imgs;
    }

    public void setImgs(List<ImageEntity> imgs) {
        Imgs = imgs;
    }
}
