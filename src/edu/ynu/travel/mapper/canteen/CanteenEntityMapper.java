package edu.ynu.travel.mapper.canteen;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.canteen.CanteenEntity;
import edu.ynu.travel.message.canteen.CanteenMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CanteenMapper")
public interface CanteenEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CanteenEntity record);

    int insertSelective(CanteenEntity record);

    List<CanteenEntity> selectAll(PageBounds pageBounds);

    CanteenMessage selectCanteenById(Integer Id);

    CanteenEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanteenEntity record);

    int updateByPrimaryKey(CanteenEntity record);

    List<CanteenMessage> listCanteenBySId(PageBounds pageBounds, int sid);
}