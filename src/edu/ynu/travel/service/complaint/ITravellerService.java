package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITravellerService {
    List<ComplaintMap> getComplaintDetail(int id);
    List<ComplaintEntity> getComplaintsByTid(int TId);
    ComplaintEntity addComplaint(ComplaintEntity complaintEntity, List<ComImgEntity> comImgEntity);
    int grade(ComplaintEntity record);
    int uploadComImg(MultipartFile file, int cid, String path);
}
