package edu.ynu.travel.service.complaint.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComTypeEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComImgEntityMapper;
import edu.ynu.travel.mapper.complaint.ComTypeEntityMapper;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.service.complaint.IComplaintService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComplaintService implements IComplaintService {

    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource
    private ComplaintEntityExample complaintExample;
    @Resource(name = "com_img")
    private ComImgEntityMapper comImgMapper;
    @Resource(name = "com_type")
    private ComTypeEntityMapper comTypeEntityMapper;

    private static final String STATUS_INIT= "待审核";
    private static final String STATUS_COMPLETE = "处理完成";

    @Override
    public List<ComplaintMap> getComplaintInteraction(int id) {
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
    public ComplaintEntity getComplaintDetail(int id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ComplaintEntity> getComplaintsByTId(int TId, int page, int size) {
        complaintExample.setOrderByClause("create_at desc");
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andUserIdEqualTo(TId);
        criteria.andReplyComIdEqualTo(0);
        PageBounds pageBounds = new PageBounds(page,size);
        return complaintMapper.selectByExample(complaintExample,pageBounds);
    }

    @Override
    public int updateStars(ComplaintEntity record) {
        record.setStatus(STATUS_COMPLETE);
        return complaintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int uploadComImg(MultipartFile file, int cid, String path) {
        if(null!=file){
            ComImgEntity comImgEntity = new ComImgEntity();
            String fileName = UUID.randomUUID().toString();
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
        complaintEntity.setStatus(STATUS_INIT);
        if(complaintMapper.insert(complaintEntity) == 1){
            return complaintEntity;
        }else{
            return null;
        }
    }

    @Override
    public ComplaintEntity replyComplaint(int cid, ComplaintEntity complaintEntity) {
        complaintEntity.setReplyComId(cid);
        if(complaintMapper.insert(complaintEntity) == 1){
            return complaintEntity;
        }else{
            return null;
        }
    }

    @Override
    public List<ComTypeEntity> getComTypes() {
        return comTypeEntityMapper.selectAll();
    }

    @Override
    public int resubmitComplaint(ComplaintEntity complaintEntity) {
        complaintEntity.setStatus(STATUS_INIT);
        //删除所属图片
        comImgMapper.deleteByComId(complaintEntity.getId());
        return complaintMapper.updateByPrimaryKeySelective(complaintEntity);
    }

    @Override
    public ComplaintList listComplaintsInit(int page, int size) {
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andStatusEqualTo("待审核");
        PageBounds pageBounds = new PageBounds(page,size);
        List complaints = complaintMapper.selectByExample(complaintExample,pageBounds);
        PageList pageList = (PageList)complaints;
        int count = pageList.getPaginator().getTotalCount();
        return new ComplaintList(complaints,count);
    }

    @Override
    public int verifyComplaint(int id, String status) {
        ComplaintEntity complaintEntity = new ComplaintEntity();
        complaintEntity.setId(id);
        complaintEntity.setStatus(status);
        return complaintMapper.updateByPrimaryKeySelective(complaintEntity);
    }

    @Override
    public ComplaintMap getComplaint(int cid) {
        return complaintMapper.selectByPrimaryKey(cid);
    }

    @Override
    public ComplaintMap replyComplaint(MultipartFile[] files, String path, ComplaintEntity complaint) {
        return null;
    }
}