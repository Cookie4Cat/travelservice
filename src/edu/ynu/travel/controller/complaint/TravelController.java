package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.complaint.ITravellerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

/***
 * [投诉模块][游客资源]
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/com/traveller")
public class TravelController {
    @Resource
    private ITravellerService travellerService;

    /***
     * 获取某个游客的投诉列表
     * @param userId 游客ID
     * @return 投诉列表
     */
    @RequestMapping(value = "/{userId}/complaints", method = RequestMethod.GET)
    public List<ComplaintEntity> getComplaintList(@PathVariable int userId){
       return travellerService.getComplaintsByTid(userId);
    }

    /***
     * 获取某次投诉
     * @param id 投诉信息ID
     * @return 投诉对话列表
     */
    @RequestMapping(value = "/complaints/{id}",method = RequestMethod.GET)
    public List<ComplaintMap> getComplaintDetail(@PathVariable int id){
        return travellerService.getComplaintDetail(id);
    }

    /***
     * 上传某个投诉信息的图片
     * @param cid 投诉信息ID
     * @param request 携带上下文用于确定存放路径信息
     * @param file 上传的文件
     * @return 通用响应信息
     */
    @RequestMapping(value = "/complaints/{cid}/images", method = RequestMethod.POST)
    public SimpleResponse uploadComImg(@PathVariable int cid, HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file){
        if(null!=file){
            String path = request.getSession().getServletContext().getRealPath("upload");
            if(travellerService.uploadComImg(file,cid,path) == 1){
                return new SimpleResponse("上传成功","success");
            }else{
                return new SimpleResponse("上传失败","error");
            }
        }else{
            return new SimpleResponse("上传失败","error");
        }
    }

    /***
     * 游客对某次投诉进行评价
     * @param cid 投诉信息ID
     * @param complaintEntity 评价星级信息 JSON => {"star": INT}
     * @return 通用响应信息
     */
    @RequestMapping(value = "/complaints/{cid}/stars",method = RequestMethod.POST)
    public SimpleResponse grade(@PathVariable int cid, @RequestBody ComplaintEntity complaintEntity){
        complaintEntity.setId(cid);
        if(travellerService.grade(complaintEntity) == 1){
            return new SimpleResponse("评价成功","success");
        }else {
            return new SimpleResponse("评价失败","error");
        }
    }
}
