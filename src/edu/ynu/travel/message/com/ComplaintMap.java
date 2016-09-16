package edu.ynu.travel.message.com;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14.
 */
public class ComplaintMap extends ComplaintEntity{

    private List<ComImgEntity> comImgs;

    public List<ComImgEntity> getComImgs() {
        return comImgs;
    }

    public void setComImgs(List<ComImgEntity> comImgs) {
        this.comImgs = comImgs;
    }
}
