package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.ComImgEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com_img")
public interface ComImgEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(ComImgEntity record);


    int insertSelective(ComImgEntity record);


    ComImgEntity selectByPrimaryKey(Integer id);


    List<ComImgEntity> selectByComId(Integer id);


    int updateByPrimaryKeySelective(ComImgEntity record);


    int updateByPrimaryKey(ComImgEntity record);

    int deleteByComId(int comId);
}