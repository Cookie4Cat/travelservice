package edu.ynu.travel.mapper.canteen;

import edu.ynu.travel.entity.canteen.CanteenEntity;
import edu.ynu.travel.message.canteen.CanteenMessage;
import org.springframework.stereotype.Repository;

@Repository("CanteenMapper")
public interface CanteenEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CanteenEntity record);

    int insertSelective(CanteenEntity record);

    CanteenMessage selectCanteenById(Integer Id);

    CanteenEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanteenEntity record);

    int updateByPrimaryKey(CanteenEntity record);
}