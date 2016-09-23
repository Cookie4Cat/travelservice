package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.complaint.IComplaintService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/com/admin")
public class AdminController {
    @Resource
    private IComplaintService complaintService;

    @RequestMapping(value = "/complaints", method = RequestMethod.GET)
    public ComplaintList getAllHandling(@RequestParam(name = "page") int page,
                                        @RequestParam(name = "size") int size){
        return complaintService.listComplaintsByStatus(page,size,"待审核");
    }

    @RequestMapping(value = "/complaints/{cid}", method = RequestMethod.POST)
    public SimpleResponse verifyComplaint(@PathVariable int cid, @RequestBody ComplaintEntity complaint){
        String status = complaint.getStatus();
        if(status.equals("处理中") || status.equals("审核被驳")){
            int i = complaintService.verifyComplaint(cid,status);
            return i==1? new SimpleResponse("审核成功","success"):new SimpleResponse("审核失败","fail");
        }else {
            return new SimpleResponse("传入参数有误","error");
        }
    }

    @RequestMapping(value = "/complaints/{cid}", method = RequestMethod.GET)
    public ComplaintMap getComplaints(@PathVariable int cid){
        return complaintService.getComplaint(cid);
    }
}
