package edu.ynu.travel.message.hotel;


import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.hotel.HotelEntity;

import java.util.List;

public class HotelMessage extends HotelEntity{
    List<ImageEntity> imgs;

    public List<ImageEntity> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImageEntity> imgs) {
        this.imgs = imgs;
    }
}
