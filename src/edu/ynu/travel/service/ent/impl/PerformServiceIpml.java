package edu.ynu.travel.service.ent.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.ent.PerformEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.mapper.ent.PerformEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.ent.PerformList;
import edu.ynu.travel.message.ent.PerformMessage;
import edu.ynu.travel.service.ent.IPerformService;
import edu.ynu.travel.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PerformServiceIpml implements IPerformService {
    @Resource(name = "PerformMapper")
    private PerformEntityMapper performMapper;
    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    @Override
    public PerformMessage selectPerformById(int id) {
        return performMapper.selectByPrimaryKey(id);
    }

    @Override
    public PerformList listPerform(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<PerformEntity> performEntities = performMapper.selectAll(pageBounds);
        PageList pageList = (PageList) performEntities;
        int count = pageList.getPaginator().getTotalCount();
        return new PerformList(count,performEntities);
    }

    @Override
    public PerformMessage addPerform(MultipartFile[] files, String path, PerformMessage performMessage) {
        List<ImageEntity> images = new ArrayList<>();
        performMapper.insertSelective(performMessage);
        int id = performMessage.getId();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    ImageEntity imageEntity = new ImageEntity();
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("ent");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        performMessage.setImages(images);
        return performMessage;
    }

    @Override
    public SimpleResponse updatePerform(MultipartFile[] files, String path, PerformMessage performMessage) {
        performMapper.updateByPrimaryKeySelective(performMessage);
        int id = performMessage.getId();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    ImageEntity image = new ImageEntity();
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    image.setForeignId(id);
                    image.setUrl(url);
                    image.setModel("ent");
                    imageEntityMapper.insert(image);
                }
            }
        }
        return new SimpleResponse("更新成功","success");
    }

    @Override
    public SimpleResponse deletePerform(int id) {
        PerformMessage performMessage = performMapper.selectByPrimaryKey(id);
        List<ImageEntity> images = performMessage.getImages();
        for (ImageEntity image: images) {
            String url = image.getUrl();
            url = FileUtil.PATH + url;
            File targetFile = new File(url);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
        imageEntityMapper.deleteByForeignId(id,"perform");
        performMapper.deleteByPrimaryKey(id);
        return new SimpleResponse("删除成功","success");
    }

    @Override
    public List<PerformMessage> selectPerformBySId(int page, int size, int sid) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<PerformMessage> performMessages = performMapper.selectByScenicId(pageBounds,sid);
        for (PerformMessage perform: performMessages) {
            int id = perform.getId();
            List<ImageEntity> images = imageEntityMapper.selectByForeignId(id,"ent");
            perform.setImages(images);
        }
        return performMessages;
    }
}
