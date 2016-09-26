package edu.ynu.travel.service.hotel;

import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.hotel.HotelList;
import edu.ynu.travel.message.hotel.HotelMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IHotelService {
    HotelList listHotel(int page,int size);
    HotelMessage getHotelById(int id);
    HotelMessage addHotel(MultipartFile[] files, String path,HotelMessage hotelMessage);
    SimpleResponse updateHotel(MultipartFile[] files, String path, HotelMessage hotelMessage);
    SimpleResponse deleteHotel(int id);
    List<HotelMessage> listByScenicId(int sid, int page, int size);
}
