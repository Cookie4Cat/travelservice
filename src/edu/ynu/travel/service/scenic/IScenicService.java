package edu.ynu.travel.service.scenic;


import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.scenic.ScenicList;
import edu.ynu.travel.message.scenic.ScenicMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IScenicService {
    ScenicList listScenic(int page, int size);
    ScenicMessage getScenicMessage(int id);
    ScenicMessage addScenic(MultipartFile[] files, String path,ScenicMessage scenicMessage);
    SimpleResponse updateScenic(MultipartFile[] files, String path, ScenicMessage scenicMessage);
    int deleteScenic(int id);
    List<ScenicMessage> getScenicList(int page, int size);
    List<ScenicEntity> listAllScenic();
}
