package edu.ynu.travel.service.scenic.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.mapper.scenic.ScenicEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.scenic.ScenicMessage;
import edu.ynu.travel.service.scenic.IScenicService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ScenicServiceImpl implements IScenicService {

    @Resource(name = "ScenicMapper")
    private ScenicEntityMapper scenicEntityMapper;
    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    @Override
    public List<ScenicEntity> listScenic(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        return scenicEntityMapper.selectAll(pageBounds);
    }

    @Override
    public ScenicMessage getScenicMessage(int id) {
        return scenicEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public ScenicMessage addScenic(MultipartFile[] files, String path, ScenicMessage scenicMessage) {
        List<ImageEntity> images = new ArrayList<>();
        scenicEntityMapper.insertSelective(scenicMessage);
        int sid =scenicMessage.getSid();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
               ImageEntity imageEntity = new ImageEntity();
                String fileName = UUID.randomUUID().toString();
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //存入图片
                try {
                    files[i].transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String url = "/upload/"+fileName;
                imageEntity.setForeignId(sid);
                imageEntity.setUrl(url);
                imageEntity.setModel("scenic");
                imageEntityMapper.insert(imageEntity);
                images.add(imageEntity);
            }
        }
        scenicMessage.setImgs(images);
        return scenicMessage;
    }

    @Override
    public SimpleResponse updateSenic(MultipartFile[] files, String path, ScenicMessage scenicMessage) {
        List<ImageEntity> images = new ArrayList<>();
        int id = scenicMessage.getSid();
        scenicEntityMapper.updateByPrimaryKeySelective(scenicMessage);
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                String fileName = UUID.randomUUID().toString();
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //存入图片
                try {
                    files[i].transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ImageEntity imageEntity = new ImageEntity();
                String url = "/upload/"+fileName;
                imageEntity.setForeignId(id);
                imageEntity.setUrl(url);
                imageEntity.setModel("scenic");
                imageEntityMapper.insert(imageEntity);
                images.add(imageEntity);
            }
        }
        scenicMessage.setImgs(images);
        return new SimpleResponse("更新成功","success");
    }
}
