package edu.ynu.travel.service.canteen;


import edu.ynu.travel.message.canteen.CanteenList;
import edu.ynu.travel.message.canteen.CanteenMessage;
import edu.ynu.travel.message.common.SimpleResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICanteenService {
    CanteenMessage getCanteenById(int id);
    CanteenList listCanteen(int page,int size);
    CanteenMessage addCanteen(MultipartFile[] files, String path, CanteenMessage canteenMessage);
    SimpleResponse updateCanteen(MultipartFile[] files, String path, CanteenMessage canteenMessage);
    SimpleResponse deleteCanteen(int id);
    List<CanteenMessage> listCanteenBySId(int sid, int page, int size);
}
