package edu.ynu.travel.controller.emergency;

import edu.ynu.travel.message.emgy.EmergencyList;
import edu.ynu.travel.service.emergency.IEmergencyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/emgy/traveler")
public class EmgyTravelerController {
    @Resource
    private IEmergencyService emergencyService;
    @RequestMapping(value = "/scenic/{sid}/emergencies", method = RequestMethod.GET)
    public EmergencyList getAllEmergency(@RequestParam(name = "page") int page,
                                         @RequestParam(name = "size") int size,@PathVariable int sid){
        return emergencyService.ListEmergency(page,size);
    }
}
