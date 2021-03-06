package edu.ynu.travel.service.image.impl;

import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.service.image.ImageService;
import edu.ynu.travel.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;



@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;


    @Override
    public int deleteImage(int id) {
        ImageEntity imageEntity = imageEntityMapper.selectByPrimaryKey(id);
        String url = imageEntity.getUrl();
        url = FileUtil.PATH + url;
        System.out.println(url);
        File targetFile = new File(url);
        return  targetFile.delete() ?imageEntityMapper.deleteByPrimaryKey(id):0;
    }
}
