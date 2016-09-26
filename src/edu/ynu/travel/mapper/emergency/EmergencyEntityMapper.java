package edu.ynu.travel.mapper.emergency;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.emergency.EmergencyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmergencyMapper")
public interface EmergencyEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(EmergencyEntity record);


    int insertSelective(EmergencyEntity record);


    List<EmergencyEntity> selectAll(PageBounds pageBounds);


    EmergencyEntity selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(EmergencyEntity record);


    int updateByPrimaryKey(EmergencyEntity record);
}