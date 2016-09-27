package edu.ynu.travel.mapper.common;

import edu.ynu.travel.entity.common.ImageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ImageMapper")
public interface ImageEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int deleteByForeignId(Integer id,String model);


    int insert(ImageEntity record);


    int insertSelective(ImageEntity record);


    ImageEntity selectByPrimaryKey(Integer id);


    List<ImageEntity> selectByForeignId(Integer id,String model);


    int updateByPrimaryKeySelective(ImageEntity record);


    int updateByPrimaryKeyWithBLOBs(ImageEntity record);


    int updateByPrimaryKey(ImageEntity record);
}