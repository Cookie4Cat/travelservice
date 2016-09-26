package edu.ynu.travel.service.ent;

import edu.ynu.travel.entity.ent.PerformEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.ent.PerformList;
import edu.ynu.travel.message.ent.PerformMessage;
import org.springframework.web.multipart.MultipartFile;


public interface IPerformService {
    PerformMessage selectPerformById(int id);
    PerformList listPerform(int page, int size);
    PerformMessage addPerform(MultipartFile[] files,String path,PerformMessage performMessage);
    SimpleResponse updatePerform(MultipartFile[] file, String path, PerformMessage performMessage);
    SimpleResponse deletePerform(int id);
}
