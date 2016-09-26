package edu.ynu.travel.message.canteen;

import edu.ynu.travel.entity.canteen.CanteenEntity;
import edu.ynu.travel.entity.common.ImageEntity;

import java.util.List;


public class CanteenMessage extends CanteenEntity {
     private List<ImageEntity> Imgs;

    public List<ImageEntity> getImgs() {
        return Imgs;
    }

    public void setImgs(List<ImageEntity> imgs) {
        Imgs = imgs;
    }
}
