package edu.ynu.travel.service.complaint.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.service.complaint.IAdminService;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource
    private ComplaintEntityExample complaintExample;

    @Override
    public ComplaintList getAllHandling(int page, int size) {
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andStatusEqualTo("待审核");
        PageBounds pageBounds = new PageBounds(page,size);
        List complaints = complaintMapper.selectByExample(complaintExample,pageBounds);
        PageList pageList = (PageList)complaints;
        int count = pageList.getPaginator().getTotalCount();
        return new ComplaintList(complaints,count);
    }

    @Override
    public int checkComplaint(int id, String status) {
        ComplaintEntity complaintEntity = new ComplaintEntity();
        complaintEntity.setId(id);
        complaintEntity.setStatus(status);
        return complaintMapper.updateByPrimaryKeySelective(complaintEntity);
    }
}
