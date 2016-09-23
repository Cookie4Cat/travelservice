package edu.ynu.travel.service.scenic;

import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.message.scenic.ScenicMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface IScenicService {
    List<ScenicEntity> listScenic(int page,int size);
    ScenicMessage getScenicMessage(int id);
    ScenicMessage addScenic(MultipartFile[] files, String path,ScenicMessage scenicMessage);
}
