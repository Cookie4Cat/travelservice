package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintList;
import edu.ynu.travel.message.com.ComplaintMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface IProcessorService {
    ComplaintList getAllHandling(int page, int size);
    List<ComplaintMap> getComplaintInteraction(int id);
    ComplaintMap replyComplaint(MultipartFile[] files,String path,ComplaintEntity complaint);
}
