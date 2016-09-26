package edu.ynu.travel.mapper.canteen;

import edu.ynu.travel.entity.canteen.CanteenEntity;
import org.springframework.stereotype.Repository;

@Repository("CanteenMapper")
public interface CanteenEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CanteenEntity record);

    int insertSelective(CanteenEntity record);

    CanteenEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanteenEntity record);

    int updateByPrimaryKey(CanteenEntity record);
}