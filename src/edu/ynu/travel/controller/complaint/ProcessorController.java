package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.service.complaint.IComplaintService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/com/processor")
public class ProcessorController {

    @Resource
    private IComplaintService complaintService;

    @RequestMapping(value = "/complaints",method = RequestMethod.GET)
    public ComplaintList getAllHandling(@RequestParam(name = "page") int page,
                                        @RequestParam(name="size") int size){
        return complaintService.listComplaintsInit(page,size);
    }

    @RequestMapping(value = "/complaints/{cid}/interaction", method = RequestMethod.GET)
    public List<ComplaintMap> getComplaintInteraction(@PathVariable int cid){
        return complaintService.getComplaintInteraction(cid);
    }

    @RequestMapping(value = "/complaints/{cid}/reply", method = RequestMethod.POST)
    public ComplaintMap replyComplaint(@PathVariable int cid, HttpServletRequest request,ComplaintMap complaintMap,
                                       @RequestParam(value = "file", required = false) MultipartFile[] files){
            String path = request.getSession().getServletContext().getRealPath("upload");
            complaintMap.setReplyComId(cid);
            return complaintService.replyComplaint(files,path,complaintMap);
    }
}
