package edu.ynu.travel.service.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;

import java.util.List;

public interface ITravelerService {
    List<ComplaintEntity> getComplainsByTID(Integer tid);
}
