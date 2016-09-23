package edu.ynu.travel.controller.scenic;

import edu.ynu.travel.entity.scenic.ScenicEntity;
import edu.ynu.travel.message.scenic.ScenicMessage;
import edu.ynu.travel.service.scenic.IScenicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/scenic/admin")
public class SAdminController {

    @Resource
    private IScenicService scenicService;

    @RequestMapping(value = "/scenic",method = RequestMethod.GET)
    public List<ScenicEntity> allScenics(@RequestParam(name = "page") int page,
                                         @RequestParam(name = "size") int size){
        return scenicService.listScenic(page,size);
    }

    @RequestMapping(value = "/scenic/{sid}",method = RequestMethod.GET)
    public ScenicMessage getScenicsDetail(@PathVariable int sid){
        return scenicService.getScenicMessage(sid);
    }

    @RequestMapping(value = "/scenic", method = RequestMethod.POST)
    public ScenicMessage createScenic( HttpServletRequest request,ScenicMessage scenicMessage,
                                       @RequestParam(value = "file", required = false) MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return scenicService.addScenic(files,path,scenicMessage);
    }
}
