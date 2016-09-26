package edu.ynu.travel.controller.hotel;

import edu.ynu.travel.message.hotel.HotelMessage;
import edu.ynu.travel.service.hotel.IHotelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hotel/traveler")
public class HTravellerController {
    @Resource
    private IHotelService hotelService;

    @RequestMapping(value = "/scenic/{sid}/hotels", method = RequestMethod.GET)
    List<HotelMessage> listHotelsBySid(@RequestParam(name = "page") int page,
                                       @RequestParam(name = "size") int size,@PathVariable int sid){
        return hotelService.listByScenicId(sid,page,size);
    }
}
