package edu.ynu.travel.service.complaint.impl;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComImgEntityMapper;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.complaint.ITravellerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class TravellerServiceImpl implements ITravellerService {
    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource(name = "com_img")
    private ComImgEntityMapper comImgMapper;
    @Resource
    private ComplaintEntityExample complaintExample;

    @Override
    public int grade(ComplaintEntity record) {
        return complaintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ComplaintEntity> getComplaintsByTid(int TId) {
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andUserIdEqualTo(TId);
        criteria.andReplyComIdEqualTo(0);
        return complaintMapper.selectByExample(complaintExample);
    }

    @Override
    public List<ComplaintMap> getComplaintDetail(int id) {
        ComplaintMap complaintMap = complaintMapper.selectByPrimaryKey(id);
        List<ComplaintMap> complaints = new ArrayList<>();
        complaints.add(complaintMap);
        ComplaintMap reply = complaintMapper.selectByReplyId(id);
        while (null != reply){
            complaints.add(reply);
            id = reply.getId();
            reply = complaintMapper.selectByReplyId(id);
        }
        return complaints;
    }

    @Override
    public int uploadComImg(MultipartFile file, int cid, String path) {
        if(null!=file){
            ComImgEntity comImgEntity = new ComImgEntity();
            String fileName = file.getOriginalFilename();
            File targetFile = new File(path, fileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            //存入图片
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //获取上传图片的url
            String url = "/upload/"+fileName;
            comImgEntity.setImageUrl(url);
            comImgEntity.setComId(cid);
            return comImgMapper.insert(comImgEntity);
        }else{
            return 0;
        }
    }

    @Override
    public ComplaintEntity createComplaint(ComplaintEntity complaintEntity) {
        if(complaintMapper.insert(complaintEntity) == 1){
            return complaintEntity;
        }else{
            return null;
        }

    }

    @Override
    public ComplaintEntity replyComplaint(int cid, ComplaintEntity complaintEntity) {
        complaintEntity.setReplyComId(cid);
        return createComplaint(complaintEntity);
    }
}
