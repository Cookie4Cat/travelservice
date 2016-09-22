package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.complaint.IAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/com/admin")
public class AdminController {
    @Resource
    private IAdminService adminService;

    @RequestMapping(value = "/complaints", method = RequestMethod.GET)
    public ComplaintList getAllHandling(@RequestParam(name = "page") int page,
                                        @RequestParam(name = "size") int size){
        return adminService.getAllHandling(page,size);
    }

    @RequestMapping(value = "/complaints/{cid}", method = RequestMethod.POST)
    public SimpleResponse verifyComplaint(@PathVariable int cid, @RequestBody String status){
        if(status=="处理中" || status=="审核被驳"){
            int i = adminService.checkComplaint(cid,status);
            return i==1? new SimpleResponse("审核成功","success"):new SimpleResponse("审核失败","fail");
        }else {
            return new SimpleResponse("传入参数有误","error");
        }
    }
}
