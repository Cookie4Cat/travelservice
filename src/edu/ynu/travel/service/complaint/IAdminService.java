package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.message.com.ComplaintList;

import java.util.List;

public interface IAdminService {
    ComplaintList getAllHandling(int page, int size);
    int checkComplaint(int id ,String status);
}
