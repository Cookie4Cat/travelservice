package edu.ynu.travel.mapper.ent;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.ent.PerformEntity;
import edu.ynu.travel.message.ent.PerformMessage;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("PerformMapper")
public interface PerformEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PerformEntity record);

    int insertSelective(PerformEntity record);

    PerformMessage selectByPrimaryKey(Integer id);

    List<PerformEntity> selectAll(PageBounds pageBounds);

    int updateByPrimaryKeySelective(PerformEntity record);

    int updateByPrimaryKey(PerformEntity record);
}