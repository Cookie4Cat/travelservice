package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComTypeEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IComplaintService {

    List<ComplaintMap> getComplaintInteraction(int id);

    ComplaintEntity getComplaintDetail(int id);

    List<ComplaintEntity> getComplaintsByTId(int TId,int page,int size);

    int updateStars(ComplaintEntity record);

    int uploadComImg(MultipartFile file, int cid, String path);

    ComplaintEntity createComplaint(ComplaintEntity complaintEntity);

    ComplaintEntity replyComplaint(int cid, ComplaintEntity complaintEntity);

    List<ComTypeEntity> getComTypes();

    int resubmitComplaint(ComplaintEntity complaintEntity);

    ComplaintList listComplaintsByStatus(int page, int size, String status);

    int verifyComplaint(int id ,String status);

    ComplaintMap getComplaint(int cid);

    ComplaintMap replyComplaint(MultipartFile[] files,String path,ComplaintMap complaintMap);

}
