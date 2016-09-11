package edu.ynu.travel.service.complaint.impl;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.service.complaint.IAdminService;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/11.
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource
    private ComplaintEntityExample complaintExample;

    @Override
    public List<ComplaintEntity> getAllHandling() {
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andStatusEqualTo("待审核");
        return complaintMapper.selectByExample(complaintExample);
    }
}
