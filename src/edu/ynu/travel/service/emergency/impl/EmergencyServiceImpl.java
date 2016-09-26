package edu.ynu.travel.service.emergency.impl;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.emergency.EmergencyEntity;
import edu.ynu.travel.mapper.emergency.EmergencyEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.emgy.EmergencyList;
import edu.ynu.travel.service.emergency.IEmergencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmergencyServiceImpl implements IEmergencyService {
    @Resource(name = "EmergencyMapper")
    private EmergencyEntityMapper emergencyMapper;

    @Override
    public EmergencyEntity getEmergencyById(int id) {
        return emergencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public EmergencyList ListEmergency(int page, int size){
        PageBounds pageBounds = new PageBounds(page,size);
        List<EmergencyEntity> emergencys = emergencyMapper.selectAll(pageBounds);
        PageList pageList = (PageList)emergencys;
        int count = pageList.getPaginator().getTotalCount();
        return new EmergencyList(count,emergencys);
    }

    @Override
    public EmergencyEntity addEmergency(EmergencyEntity emergencyEntity) {
        emergencyMapper.insertSelective(emergencyEntity);
        return emergencyEntity;
    }

    @Override
    public SimpleResponse updateEmergency( EmergencyEntity emergencyEntity){
        emergencyMapper.updateByPrimaryKeySelective(emergencyEntity);
        return new SimpleResponse("更新成功","success");
    }

    @Override
    public SimpleResponse deleteEmergency(int id) {
        emergencyMapper.deleteByPrimaryKey(id);
        return new SimpleResponse("删除成功","success");
    }
}
