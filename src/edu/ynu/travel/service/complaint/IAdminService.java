package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;

import java.util.List;

public interface IAdminService {
    List<ComplaintEntity> getAllHandling();
}
