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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
@Service
public class TravellerServiceImpl implements ITravellerService {
    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource(name = "com_img")
    private ComImgEntityMapper comImgMapper;
    @Resource
    private ComplaintEntityExample complaintExample;

    @Override
    public ComplaintEntity addComplaint(ComplaintEntity record, List<ComImgEntity> comImgEntity) {
//        complaintMapper.insertSelective(record);
//        comImgEntity.setComId(record.getId());
//        comImgMapper.insertSelective(comImgEntity);
        return null;
    }

    @Override
    public SimpleResponse grade(ComplaintEntity record) {
        complaintMapper.updateByPrimaryKeySelective(record);
        return new SimpleResponse("评分成功","success");
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
        List<ComplaintMap> complaints = new ArrayList();
        complaints.add(complaintMap);
        ComplaintMap reply = complaintMapper.selectByReplyId(id);
        while (null != reply){
            complaints.add(reply);
            id = reply.getId();
            reply = complaintMapper.selectByReplyId(id);
        }
        return complaints;
    }
}
