package edu.ynu.travel.controller.emergency;

import edu.ynu.travel.entity.emergency.InfoEntity;
import edu.ynu.travel.service.emergency.InfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoServiceImpl;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public InfoEntity getInfo(@PathVariable Integer id){
        InfoEntity infoEntity = infoServiceImpl.getInfo(id);
        return infoEntity;
    }
}
