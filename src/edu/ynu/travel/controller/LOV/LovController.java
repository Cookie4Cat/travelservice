package edu.ynu.travel.controller.LOV;

import edu.ynu.travel.entity.complaint.ComTypeEntity;
import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.service.complaint.IComplaintService;
import edu.ynu.travel.service.scenic.IScenicService;
import edu.ynu.travel.service.user.IMenuService;
import edu.ynu.travel.service.user.IRoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/lovs")
public class LovController {
    @Resource
    private IComplaintService complaintService;
    @Resource
    private IScenicService scenicService;
    @Resource
    private IMenuService menuService;
    @Resource
    private IRoleService roleService;

    @RequestMapping(value = "/complaints/types", method = RequestMethod.GET)
    public List<ComTypeEntity> getAllTypes(){
        return complaintService.getComTypes();
    }

    @RequestMapping(value = "/scenic", method = RequestMethod.GET)
    public List<ScenicEntity> getAllScenic(){
        return scenicService.listAllScenic();
    }

    @RequestMapping(value = "/users/menus",method = RequestMethod.GET)
    public List<MenuEntity> getAllMenu(){
        return menuService.listAll();
    }

    @RequestMapping(value = "/users/roles",method = RequestMethod.GET)
    public List<RoleEntity> gatAllRole(){
        return roleService.listAllRole();
    }

}
