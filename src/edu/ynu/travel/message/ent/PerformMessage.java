package edu.ynu.travel.message.ent;

import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.ent.PerformEntity;

import java.util.List;


public class PerformMessage extends PerformEntity {
   private List<ImageEntity> images;

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
}
