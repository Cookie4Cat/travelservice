package edu.ynu.travel.controller.LOV;

import edu.ynu.travel.entity.complaint.ComTypeEntity;
import edu.ynu.travel.service.complaint.IComplaintService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/lovs")
public class LovController {
    @Resource
    private IComplaintService complaintService;

    @RequestMapping(value = "/complaints/types", method = RequestMethod.GET)
    public List<ComTypeEntity> getAllTypes(){
        return complaintService.getComTypes();
    }
}
