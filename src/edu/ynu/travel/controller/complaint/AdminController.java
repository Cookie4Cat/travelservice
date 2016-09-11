package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.service.complaint.IAdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/11.
 */
@RestController
@RequestMapping(value = "/com/admin")
public class AdminController {
    @Resource
    private IAdminService adminService;

    @RequestMapping(value = "/complaints/handling", method = RequestMethod.GET)
    public List<ComplaintEntity> getAllHandling(){
        return adminService.getAllHandling();
    }
}
