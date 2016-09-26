package edu.ynu.travel.service.emergency;

import edu.ynu.travel.entity.emergency.EmergencyEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.emgy.EmergencyList;

import java.util.List;


public interface IEmergencyService {
    EmergencyEntity getEmergencyById(int id);
    EmergencyList ListEmergency(int page, int size);
    EmergencyEntity addEmergency(EmergencyEntity emergencyEntity);
    SimpleResponse updateEmergency( EmergencyEntity emergencyEntity);
    SimpleResponse deleteEmergency(int id);
    List<EmergencyEntity> listBySid(int sid, int page, int size);
}
