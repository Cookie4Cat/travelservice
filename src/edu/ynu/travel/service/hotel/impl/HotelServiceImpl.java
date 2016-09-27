package edu.ynu.travel.service.hotel.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.common.ImageEntity;
import edu.ynu.travel.entity.hotel.HotelEntity;
import edu.ynu.travel.mapper.common.ImageEntityMapper;
import edu.ynu.travel.mapper.hotel.HotelEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.hotel.HotelList;
import edu.ynu.travel.message.hotel.HotelMessage;
import edu.ynu.travel.service.hotel.IHotelService;
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
public class HotelServiceImpl implements IHotelService{

    @Resource(name = "HotelMapper")
    private HotelEntityMapper hotelMapper;
    @Resource(name = "ImageMapper")
    private ImageEntityMapper imageEntityMapper;

    @Override
    public HotelList listHotel(int page,int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<HotelEntity> hotels = hotelMapper.selectAll(pageBounds);
        PageList pageList = (PageList) hotels;
        int count = pageList.getPaginator().getTotalCount();
        return new HotelList(count,pageList);
    }

    @Override
    public HotelMessage getHotelById(int id) {
        return hotelMapper.selectByPrimaryKey(id);
    }

    @Override
    public HotelMessage addHotel(MultipartFile[] files, String path, HotelMessage hotelMessage) {
        List<ImageEntity> images = new ArrayList<>();
        hotelMapper.insertSelective(hotelMessage);
        int id =hotelMessage.getId();
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0) {
                    ImageEntity imageEntity = new ImageEntity();
                    String fileName = FileUtil.saveFile(path, files[i]);
                    String url = "/upload/" + fileName;
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("hotel");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        hotelMessage.setImgs(images);
        return hotelMessage;
    }

    @Override
    public SimpleResponse updateHotel( MultipartFile[] files, String path, HotelMessage hotelMessage) {
        List<ImageEntity> images = new ArrayList<>();
        int id = hotelMessage.getId();
        hotelMapper.updateByPrimaryKeySelective(hotelMessage);
        if (null != files) {
            for (int i = 0; i <= files.length - 1; i++) {
                if(files[i].getSize()!=0){
                    String fileName =FileUtil.saveFile(path,files[i]);
                    ImageEntity imageEntity = new ImageEntity();
                    String url = "/upload/"+fileName;
                    imageEntity.setForeignId(id);
                    imageEntity.setUrl(url);
                    imageEntity.setModel("hotel");
                    imageEntityMapper.insert(imageEntity);
                    images.add(imageEntity);
                }
            }
        }
        hotelMessage.setImgs(images);
        return new SimpleResponse("更新成功","success");
    }

    @Override
    public SimpleResponse deleteHotel(int id) {
        HotelMessage hotelMessage = hotelMapper.selectByPrimaryKey(id);
        List<ImageEntity> images = hotelMessage.getImgs();
        for (ImageEntity image: images) {
            String url =FileUtil.PATH + image.getUrl();
            File targetFile = new File(url);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
        imageEntityMapper.deleteByForeignId(id);
        return hotelMapper.deleteByPrimaryKey(id)==1?new SimpleResponse("删除成功","success"): new SimpleResponse("删除失败","fail");
    }

    @Override
    public List<HotelMessage> listByScenicId(int sid, int page, int size) {
        PageBounds pageBounds = new PageBounds(page, size);
        List<HotelMessage> hotelMessages = hotelMapper.listByScenicId(pageBounds,sid);
        for (HotelMessage hotel: hotelMessages) {
            int id = hotel.getId();
            List<ImageEntity> images = imageEntityMapper.selectByForeignId(id,"hotel");
            hotel.setImgs(images);
        }
        return hotelMessages;
    }
}