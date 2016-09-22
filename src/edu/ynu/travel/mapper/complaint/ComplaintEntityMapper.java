package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.ComplaintEntity;
import edu.ynu.travel.entity.complaint.ComplaintEntityExample;
import edu.ynu.travel.message.com.ComplaintMap;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

@Repository("complaintMapper")
public interface ComplaintEntityMapper {

    int countByExample(ComplaintEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplaintEntity record);

    int insertSelective(ComplaintEntity record);

    List<ComplaintEntity> selectByExample(ComplaintEntityExample example,PageBounds pageBounds);

    List<ComplaintEntity> selectByExample(ComplaintEntityExample example);

    ComplaintMap selectByPrimaryKey(Integer id);

    ComplaintMap selectByReplyId(Integer id);

    int updateByPrimaryKeySelective(ComplaintEntity record);

    int updateByPrimaryKey(ComplaintEntity record);
}