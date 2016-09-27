package edu.ynu.travel.controller.canteen;

import edu.ynu.travel.message.canteen.CanteenMessage;
import edu.ynu.travel.service.canteen.ICanteenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cant/traveler")
public class CTravelerController {
    @Resource
    private ICanteenService canteenService;

    @RequestMapping(value = "/scenic/{sid}/canteens",method = RequestMethod.GET)
    public List<CanteenMessage> listBySid(@RequestParam(name = "page") int page,
                                          @RequestParam(name = "size") int size, @PathVariable int sid){
        return canteenService.listCanteenBySId(sid,page,size);
    }

}
