package edu.ynu.travel.controller.complaint;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.complaint.ITravellerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/11.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/com/traveller")
public class TravelController {
    @Resource
    private ITravellerService travellerService;

    @RequestMapping(value = "/{Tid}/complaints",produces="application/json;charset=UTF-8",method = RequestMethod.POST)

    public ComplaintEntity submitComplaint(@PathVariable int Tid, ComplaintEntity complaint,
                                           @RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request){
        List<ComImgEntity> comImgs =new ArrayList();
        ComImgEntity comImgEntity = new ComImgEntity();
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //构造文件的保存路径
                System.out.println("开始");
                String path = request.getSession().getServletContext().getRealPath("upload");
                String fileName = file.getOriginalFilename();
                System.out.println(path);
                File targetFile = new File(path, fileName);
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }

                //保存
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //获取上传图片的url
                String url = request.getContextPath()+"/upload/"+fileName;
                comImgEntity.setImageUrl(url);
                comImgs.add(comImgEntity);
            }
        }
        //拼装对象
        complaint.setUserId(Tid);
        return travellerService.addComplaint(complaint,comImgs);
    }

    @RequestMapping(value = "/complaints/{cid}/stars",method = RequestMethod.POST)
    public SimpleResponse grade(@PathVariable int cid, @RequestBody ComplaintEntity complaintEntity){
        complaintEntity.setId(cid);
        return travellerService.grade(complaintEntity);
    }

    @RequestMapping(value = "/{userId}/complaints", method = RequestMethod.GET)
    public List<ComplaintEntity> getComplaintList(@PathVariable int userId){
       return travellerService.getComplaintsByTid(userId);
    }

    @RequestMapping(value = "/complaints/{id}",method = RequestMethod.GET)
    public List<ComplaintMap> getComplaintDetail(@PathVariable int id){
        return travellerService.getComplaintDetail(id);
    }
}
