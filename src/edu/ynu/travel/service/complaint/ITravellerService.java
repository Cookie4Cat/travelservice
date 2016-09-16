package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintMap;
import edu.ynu.travel.message.common.SimpleResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface ITravellerService {
    List<ComplaintMap> getComplaintDetail(int id);
    List<ComplaintEntity> getComplaintsByTid(int TId);
    ComplaintEntity addComplaint(ComplaintEntity complaintEntity, List<ComImgEntity> comImgEntity);
    SimpleResponse grade(ComplaintEntity record);
}
