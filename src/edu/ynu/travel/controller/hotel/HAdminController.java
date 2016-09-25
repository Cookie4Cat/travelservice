package edu.ynu.travel.controller.hotel;

import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.hotel.HotelList;
import edu.ynu.travel.message.hotel.HotelMessage;
import edu.ynu.travel.message.scenic.ScenicMessage;
import edu.ynu.travel.service.hotel.IHotelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hotel/admin")
public class HAdminController {
    @Resource
    private IHotelService hotelService;

    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public HotelList getAllHotels(@RequestParam(name = "page") int page,
                                  @RequestParam(name = "size") int size){
        return hotelService.listHotel(page,size);
    }

    @RequestMapping(value = "/hotels/{id}", method = RequestMethod.GET)
    public HotelMessage getHotelById(@PathVariable int id){
        return hotelService.getHotelById(id);
    }
    @RequestMapping(value = "/hotels", method = RequestMethod.POST)
    public HotelMessage addHotel(HttpServletRequest request, HotelMessage hotelMessage,
                                 @RequestParam(value = "file",required = false)MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return hotelService.addHotel(files,path,hotelMessage);
    }

    @RequestMapping(value = "/scenic/{id}", method = RequestMethod.POST)
    public SimpleResponse updateHotel(HttpServletRequest request,HotelMessage hotelMessage, @PathVariable int id,
                                       @RequestParam(value = "file") MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        hotelMessage.setId(id);
        return hotelService.updateHotel(files,path,hotelMessage);
    }

    @RequestMapping(value = "/scenic/{id}/delete", method = RequestMethod.POST)
    public SimpleResponse deleteHotel(@PathVariable int id){
        return hotelService.deleteHotel(id);
    }

}
