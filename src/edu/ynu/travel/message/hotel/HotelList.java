package edu.ynu.travel.message.hotel;

import edu.ynu.travel.entity.hotel.HotelEntity;

import java.util.List;


public class HotelList {
    private List<HotelEntity> hotels;
    private int count;

    public HotelList(int count, List<HotelEntity> hotels) {
        this.count = count;
        this.hotels = hotels;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
    }
}
