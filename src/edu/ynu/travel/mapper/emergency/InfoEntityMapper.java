package edu.ynu.travel.mapper.emergency;

import edu.ynu.travel.entity.emergency.InfoEntity;
import org.springframework.stereotype.Repository;

@Repository("InfoMapper")
public interface InfoEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(InfoEntity record);

    int insertSelective(InfoEntity record);

    InfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoEntity record);

    int updateByPrimaryKey(InfoEntity record);
}