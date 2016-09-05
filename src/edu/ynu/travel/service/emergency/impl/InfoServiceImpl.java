package edu.ynu.travel.service.emergency.impl;

import edu.ynu.travel.entity.emergency.InfoEntity;
import edu.ynu.travel.mapper.emergency.InfoEntityMapper;
import edu.ynu.travel.service.emergency.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource(name = "InfoMapper")
    private InfoEntityMapper infoEntityMapper;

    @Override
    public InfoEntity getInfo(Integer id){
        return infoEntityMapper.selectByPrimaryKey(id);
    }
}
