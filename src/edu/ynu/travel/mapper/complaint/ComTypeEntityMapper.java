package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.ComTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com_type")
public interface ComTypeEntityMapper {

    List<ComTypeEntity> selectAll();


    int deleteByPrimaryKey(Integer typeId);


    int insert(ComTypeEntity record);


    int insertSelective(ComTypeEntity record);


    ComTypeEntity selectByPrimaryKey(Integer typeId);


    int updateByPrimaryKeySelective(ComTypeEntity record);


    int updateByPrimaryKey(ComTypeEntity record);
}