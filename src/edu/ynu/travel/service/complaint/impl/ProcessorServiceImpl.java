package edu.ynu.travel.service.complaint.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.service.complaint.IProcessorService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Service
public class ProcessorServiceImpl implements IProcessorService{

    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintMapper;
    @Resource
    private ComplaintEntityExample complaintExample;

    @Override
    public ComplaintList getAllHandling(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        ComplaintEntityExample.Criteria criteria  =  complaintExample.createCriteria();
        criteria.andStatusEqualTo("待审核");
        List complaints = complaintMapper.selectByExample(complaintExample,pageBounds);
        PageList pageList = (PageList)complaints;
        int count = pageList.getPaginator().getTotalCount();
        return new ComplaintList(complaints,count);
    }

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
    public ComplaintMap replyComplaint(MultipartFile[] files, String path, ComplaintEntity complaint) {
        return null;
    }
}
