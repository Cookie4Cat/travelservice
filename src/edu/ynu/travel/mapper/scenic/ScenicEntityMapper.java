package edu.ynu.travel.mapper.scenic;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.message.scenic.ScenicMessage;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("ScenicMapper")
public interface ScenicEntityMapper {

    int deleteByPrimaryKey(Integer sid);


    int insert(ScenicEntity record);


    int insertSelective(ScenicEntity record);


    ScenicMessage selectByPrimaryKey(Integer sid);


    List<ScenicEntity> selectAll(PageBounds pageBounds);


    List<ScenicEntity> selectAll();


    int updateByPrimaryKeySelective(ScenicEntity record);



    int updateByPrimaryKey(ScenicEntity record);


    List<ScenicMessage> listAllScenic(PageBounds pageBounds);
}