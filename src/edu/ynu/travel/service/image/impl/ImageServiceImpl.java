package edu.ynu.travel.service.image.impl;

import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.service.image.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;



@Service
public class ImageServiceImpl implements ImageService {

    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    private static final String PATH = "C:\\Users\\Administrator\\IdeaProjects\\tour\\WebRoot";

    @Override
    public int deleteImage(int id) {
        ImageEntity imageEntity = imageEntityMapper.selectByPrimaryKey(id);
        String url = imageEntity.getUrl();
        url = PATH + url;
        System.out.println(url);
        File targetFile = new File(url);
        return  targetFile.delete() ?imageEntityMapper.deleteByPrimaryKey(id):0;
    }
}
