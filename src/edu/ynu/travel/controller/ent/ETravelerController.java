package edu.ynu.travel.controller.ent;


import edu.ynu.travel.message.ent.PerformMessage;
import edu.ynu.travel.service.ent.IPerformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/ent/traveler")
public class ETravelerController {
    @Resource
    private IPerformService performService;

    @RequestMapping(value = "/scenic/{id}/performances", method = RequestMethod.GET)
    public List<PerformMessage> listPerformBySId(@PathVariable int id,
                                                 @RequestParam(name = "page") int page,@RequestParam(name = "size") int size){
        return performService.selectPerformBySId(page,size,id);
    }
}
