package edu.ynu.travel.controller.scenic;

import edu.ynu.travel.service.scenic.IScenicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "scenic/traveler")
public class TravellerController {
    @Resource
    private IScenicService scenicService;

    @RequestMapping(value = "/scenic", method = RequestMethod.GET)
    public Object getScenicList(@RequestParam(name = "page") int page,
                                @RequestParam(name = "size") int size){
        return scenicService.getScenicList(page,size);
    }
}
