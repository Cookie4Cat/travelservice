package edu.ynu.travel.message.canteen;


import edu.ynu.travel.entity.canteen.CanteenEntity;

import java.util.List;

public class CanteenList {
    private List<CanteenEntity> canteens;
    private int count;

    public CanteenList(List<CanteenEntity> canteens, int count) {
        this.canteens = canteens;
        this.count = count;
    }

    public List<CanteenEntity> getCanteens() {
        return canteens;
    }

    public void setCanteens(List<CanteenEntity> canteens) {
        this.canteens = canteens;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
