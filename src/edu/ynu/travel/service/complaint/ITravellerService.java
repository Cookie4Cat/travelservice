package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComTypeEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITravellerService {
    List<ComplaintMap> getComplaintDetail(int id);
    List<ComplaintEntity> getComplaintsByTid(int TId);
    int grade(ComplaintEntity record);
    int uploadComImg(MultipartFile file, int cid, String path);
    ComplaintEntity createComplaint(ComplaintEntity complaintEntity);
    ComplaintEntity replyComplaint(int cid, ComplaintEntity complaintEntity);
    List<ComTypeEntity> getComTypes();
}
