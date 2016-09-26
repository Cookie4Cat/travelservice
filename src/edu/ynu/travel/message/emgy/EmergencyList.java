package edu.ynu.travel.message.emgy;




import edu.ynu.travel.entity.emergency.EmergencyEntity;

import java.util.List;

public class EmergencyList {
    private List<EmergencyEntity> emergencyEntities;
    private int count;

    public EmergencyList(int count, List<EmergencyEntity> emergencyEntities) {
        this.count = count;
        this.emergencyEntities = emergencyEntities;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<EmergencyEntity> getEmergencyEntities() {
        return emergencyEntities;
    }

    public void setEmergencyEntities(List<EmergencyEntity> emergencyEntities) {
        this.emergencyEntities = emergencyEntities;
    }
}
