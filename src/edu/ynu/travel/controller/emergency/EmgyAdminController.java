package edu.ynu.travel.controller.emergency;

import edu.ynu.travel.entity.emergency.EmergencyEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.emgy.EmergencyList;
import edu.ynu.travel.service.emergency.IEmergencyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/emgy/admin")
public class EmgyAdminController {
    @Resource
    private IEmergencyService emergencyService;

    @RequestMapping(value = "/emergencies/{id}", method = RequestMethod.GET)
    public EmergencyEntity getEmergency(@PathVariable int id){
        return emergencyService.getEmergencyById(id);
    }

    @RequestMapping(value = "/emergencies", method = RequestMethod.GET)
    public EmergencyList getAllEmergency(@RequestParam(name = "page") int page,
                                         @RequestParam(name = "size") int size){
        return emergencyService.ListEmergency(page,size);
    }

    @RequestMapping(value = "/emergencies", method = RequestMethod.POST)
    public EmergencyEntity addEmergency(@RequestBody EmergencyEntity emergencyEntity){
        return emergencyService.addEmergency(emergencyEntity);
    }

    @RequestMapping(value = "/emergencies/{id}", method = RequestMethod.POST)
    public SimpleResponse updateEmergency(@PathVariable int id, @RequestBody EmergencyEntity emergencyEntity){
        return emergencyService.updateEmergency(emergencyEntity);
    }

    @RequestMapping(value = "/emergency/{id}/delete",method = RequestMethod.POST)
    public SimpleResponse deleteEmergency(@PathVariable int id){
        return emergencyService.deleteEmergency(id);
    }
}
