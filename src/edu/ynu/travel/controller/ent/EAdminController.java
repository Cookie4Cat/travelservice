package edu.ynu.travel.controller.ent;

import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.ent.PerformList;
import edu.ynu.travel.message.ent.PerformMessage;
import edu.ynu.travel.service.ent.IPerformService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/ent/admin")
public class EAdminController {
    @Resource
    private IPerformService performService;

    @RequestMapping(value = "/performances/{id}", method = RequestMethod.GET)
    public PerformMessage getPerformById(@PathVariable int id){
        return performService.selectPerformById(id);
    }

    @RequestMapping(value = "/performances", method = RequestMethod.GET)
    public PerformList getPerformAll(@RequestParam(name = "page") int page,
                                   @RequestParam(name = "size") int size){
        return performService.listPerform(page,size);
    }

    @RequestMapping(value = "/performances", method =  RequestMethod.POST)
    public PerformMessage addPerformance(HttpServletRequest request, PerformMessage performMessage,
                                          @RequestParam(value = "file", required = false)MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return performService.addPerform(files,path,performMessage);
    }

    @RequestMapping(value = "/performances/{id}", method = RequestMethod.POST)
    public SimpleResponse updatePerform(HttpServletRequest request, PerformMessage performMessage,
                                        @RequestParam(value = "file")MultipartFile[] files,@PathVariable int id){
        String path = request.getSession().getServletContext().getRealPath("upload");
        performMessage.setId(id);
        return  performService.updatePerform(files,path,performMessage);
    }

    @RequestMapping(value = "performances/{id}/delete", method = RequestMethod.POST)
    public SimpleResponse deletePerform(@PathVariable int id){
        return performService.deletePerform(id);
    }

}
