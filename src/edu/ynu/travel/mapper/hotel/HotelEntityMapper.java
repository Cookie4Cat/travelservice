package edu.ynu.travel.mapper.hotel;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.hotel.HotelEntity;
import edu.ynu.travel.message.hotel.HotelMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("HotelMapper")
public interface HotelEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(HotelEntity record);


    int insertSelective(HotelEntity record);


    List<HotelEntity> selectAll(PageBounds pageBounds);


    HotelMessage selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(HotelEntity record);


    int updateByPrimaryKey(HotelEntity record);
}