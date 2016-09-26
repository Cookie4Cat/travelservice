package edu.ynu.travel.service.emergency;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.emergency.EmergencyEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.emgy.EmergencyList;


public interface IEmergencyService {
    EmergencyEntity getEmergencyById(int id);
    EmergencyList ListEmergency(int page, int size);
    EmergencyEntity addEmergency(EmergencyEntity emergencyEntity);
    SimpleResponse updateEmergency( EmergencyEntity emergencyEntity);
    SimpleResponse deleteEmergency(int id);
}
