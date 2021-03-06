package edu.ynu.travel.service.scenic.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.mapper.scenic.ScenicEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.scenic.ScenicList;
import edu.ynu.travel.message.scenic.ScenicMessage;
import edu.ynu.travel.service.scenic.IScenicService;
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
public class ScenicServiceImpl implements IScenicService {

    @Resource(name = "ScenicMapper")
    private ScenicEntityMapper scenicEntityMapper;
    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    @Override
    public ScenicList listScenic(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<ScenicEntity> scenic = scenicEntityMapper.selectAll(pageBounds);
        PageList pageList = (PageList)scenic;
        int count = pageList.getPaginator().getTotalCount();
        return new ScenicList(count,scenic);
    }

    @Override
    public ScenicMessage getScenicMessage(int id) {
        return scenicEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public ScenicMessage addScenic(MultipartFile[] files, String path, ScenicMessage scenicMessage) {
        System.out.println("------"+path+"-------");
        List<ImageEntity> images = new ArrayList<>();
        scenicEntityMapper.insertSelective(scenicMessage);
        int sid =scenicMessage.getSid();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    ImageEntity imageEntity = new ImageEntity();
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    imageEntity.setForeignId(sid);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("scenic");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        scenicMessage.setImgs(images);
        return scenicMessage;
    }

    @Override
    public SimpleResponse updateScenic(MultipartFile[] files, String path, ScenicMessage scenicMessage) {
        List<ImageEntity> images = new ArrayList<>();
        int id = scenicMessage.getSid();
        scenicEntityMapper.updateByPrimaryKeySelective(scenicMessage);
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0){
                    String fileName =FileUtil.saveFile(path,files[i]);
                    ImageEntity imageEntity = new ImageEntity();
                    String url = "/upload/"+fileName;
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("scenic");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        scenicMessage.setImgs(images);
        return new SimpleResponse("更新成功","success");
    }

    @Override
    public int deleteScenic(int id) {
        ScenicMessage scenicMessage = scenicEntityMapper.selectByPrimaryKey(id);
        List<ImageEntity> imgs = scenicMessage.getImgs();
        for (ImageEntity image: imgs) {
            String url = image.getUrl();
            url = FileUtil.PATH + url;
            File targetFile = new File(url);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
        imageEntityMapper.deleteByForeignId(id,"scenic");
        return scenicEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ScenicMessage> getScenicList(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<ScenicMessage> scenicMessages = scenicEntityMapper.listAllScenic(pageBounds);
        for (ScenicMessage scenic: scenicMessages) {
            int id = scenic.getSid();
            List<ImageEntity> images = imageEntityMapper.selectByForeignId(id,"scenic");
            scenic.setImgs(images);
        }
        return scenicMessages;
    }

    @Override
    public List<ScenicEntity> listAllScenic() {
        return scenicEntityMapper.selectAll();
    }
}
