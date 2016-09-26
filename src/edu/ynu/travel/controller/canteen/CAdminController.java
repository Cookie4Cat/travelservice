package edu.ynu.travel.controller.canteen;


import edu.ynu.travel.message.canteen.CanteenList;
import edu.ynu.travel.message.canteen.CanteenMessage;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.canteen.ICanteenService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cant/admin")
public class CAdminController {
    @Resource
    private ICanteenService canteenService;

    @RequestMapping(value = "/canteens/{id}", method = RequestMethod.GET)
    public CanteenMessage getCanteen(@PathVariable int id){
        return canteenService.getCanteenById(id);
    }

    @RequestMapping(value = "canteens", method = RequestMethod.GET)
    public CanteenList  getAllCanteen(@RequestParam(name = "page") int page,
                                      @RequestParam(name = "size") int size){
        return canteenService.listCanteen(page,size);
    }

    @RequestMapping(value = "/canteens",method = RequestMethod.POST)
    public CanteenMessage createCanteen(HttpServletRequest request,CanteenMessage canteenMessage,
                                     @RequestParam(value = "file", required = false) MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return canteenService.addCanteen(files,path,canteenMessage);
    }

    @RequestMapping(value = "/canteens/{id}",method = RequestMethod.POST)
    public SimpleResponse updateCanteen(HttpServletRequest request, CanteenMessage canteenMessage, @PathVariable int id,
                                        @RequestParam(value = "file", required = false) MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        canteenMessage.setId(id);
        return canteenService.updateCanteen(files,path,canteenMessage);
    }

    @RequestMapping(value = "/canteen/{id}/delete",method = RequestMethod.POST)
    public SimpleResponse deleteCanteen(@PathVariable int id){
        return canteenService.deleteCanteen(id);
    }
}
