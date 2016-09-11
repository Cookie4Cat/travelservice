package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("complaintMapper")
public interface ComplaintEntityMapper {

    int countByExample(ComplaintEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplaintEntity record);

    List<ComplaintEntity> selectByExample(ComplaintEntityExample example);

    ComplaintEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComplaintEntity record);

    int updateByPrimaryKey(ComplaintEntity record);
}