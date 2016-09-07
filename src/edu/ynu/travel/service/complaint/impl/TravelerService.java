package edu.ynu.travel.service.complaint.impl;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.mapper.complaint.ComplaintEntityMapper;
import edu.ynu.travel.service.complaint.ITravelerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TravelerService implements ITravelerService {
    @Resource(name = "complaintMapper")
    private ComplaintEntityMapper complaintEntityMapper;
    @Override
    public List<ComplaintEntity> getComplainsByTID(Integer tid) {
        ComplaintEntityExample example = new ComplaintEntityExample();

        complaintEntityMapper.selectByExample(example);
        return null;
    }
}
