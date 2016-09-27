package edu.ynu.travel.service.canteen.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.canteen.CanteenEntity;
import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.mapper.canteen.CanteenEntityMapper;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.message.canteen.CanteenList;
import edu.ynu.travel.message.canteen.CanteenMessage;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.canteen.ICanteenService;
import edu.ynu.travel.util.FileUtil;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CanteenServiceImpl implements ICanteenService{

    @Resource(name = "CanteenMapper")
    private CanteenEntityMapper canteenMapper;
    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    @Override
    public CanteenMessage getCanteenById(int id) {
        return canteenMapper.selectCanteenById(id);
    }

    @Override
    public CanteenList listCanteen(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<CanteenEntity> canteenEntities = canteenMapper.selectAll(pageBounds);
        PageList pageList = (PageList)canteenEntities;
        int count =((PageList) canteenEntities).getPaginator().getTotalCount();
        return new CanteenList(canteenEntities,count);
    }

    @Override
    public CanteenMessage addCanteen(MultipartFile[] files, String path, CanteenMessage canteenMessage) {
        List<ImageEntity> images = new ArrayList<>();
        canteenMapper.insertSelective(canteenMessage);
        int id = canteenMessage.getId();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    ImageEntity imageEntity = new ImageEntity();
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("canteen");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        canteenMessage.setImgs(images);
        return canteenMessage;
    }

    @Override
    public SimpleResponse updateCanteen(MultipartFile[] files, String path, CanteenMessage canteenMessage) {
        canteenMapper.updateByPrimaryKeySelective(canteenMessage);
        int id = canteenMessage.getId();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    ImageEntity imageEntity = new ImageEntity();
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("canteen");
                    imageEntityMapper.insert(imageEntity);
                }
            }
        }
        return new SimpleResponse("更新成功","success");
    }

    @Override
    public SimpleResponse deleteCanteen(int id) {
       CanteenMessage canteenMessage = canteenMapper.selectCanteenById(id);
        List<ImageEntity> images = canteenMessage.getImgs();
        for (ImageEntity image: images) {
            String url = image.getUrl();
            url = FileUtil.PATH + url;
            File targetFile = new File(url);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
        imageEntityMapper.deleteByForeignId(id);
        canteenMapper.deleteByPrimaryKey(id);
        return new SimpleResponse("删除成功","success");
    }

    @Override
    public List<CanteenMessage> listCanteenBySId(int sid, int page, int size) {
        PageBounds pageBounds = new PageBounds(page, size);
        List<CanteenMessage> canteenMessages = canteenMapper.listCanteenBySId(pageBounds, sid);
        for (CanteenMessage canteen: canteenMessages) {
            int id = canteen.getId();
            List<ImageEntity> images = imageEntityMapper.selectByForeignId(id,"canteen");
            canteen.setImgs(images);
        }
        return canteenMessages;
    }
}
