package edu.ynu.travel.service.scenic;


import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.scenic.ScenicList;
import edu.ynu.travel.message.scenic.ScenicMessage;
import org.springframework.web.multipart.MultipartFile;



/**
 * Created by Administrator on 2016/9/23.
 */
public interface IScenicService {
    ScenicList listScenic(int page, int size);
    ScenicMessage getScenicMessage(int id);
    ScenicMessage addScenic(MultipartFile[] files, String path,ScenicMessage scenicMessage);
    SimpleResponse updateScenic(MultipartFile[] files, String path, ScenicMessage scenicMessage);
    int deleteScenic(int id);
}
