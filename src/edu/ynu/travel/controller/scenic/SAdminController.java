package edu.ynu.travel.controller.scenic;


import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.scenic.ScenicList;
import edu.ynu.travel.message.scenic.ScenicMessage;
import edu.ynu.travel.service.image.ImageService;
import edu.ynu.travel.service.scenic.IScenicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/scenic/admin")
public class SAdminController {

    @Resource
    private IScenicService scenicService;


    @RequestMapping(value = "/scenic",method = RequestMethod.GET)
    public ScenicList allScenic(@RequestParam(name = "page") int page,
                                 @RequestParam(name = "size") int size){
        return scenicService.listScenic(page,size);
    }

    @RequestMapping(value = "/scenic/{sid}",method = RequestMethod.GET)
    public ScenicMessage getScenicDetail(@PathVariable int sid){
        return scenicService.getScenicMessage(sid);
    }

    @RequestMapping(value = "/scenic", method = RequestMethod.POST)
    public ScenicMessage createScenic( HttpServletRequest request,ScenicMessage scenicMessage,
                                       @RequestParam(value = "file", required = false) MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return scenicService.addScenic(files,path,scenicMessage);
    }

    @RequestMapping(value = "/scenic/{sid}", method = RequestMethod.POST)
    public SimpleResponse updateScenic(HttpServletRequest request,ScenicMessage scenicMessage,@PathVariable int sid,
                                      @RequestParam(value = "file") MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("upload");
        scenicMessage.setSid(sid);
        return scenicService.updateScenic(files,path,scenicMessage);
    }


    @RequestMapping(value = "/scenic/{id}/delete",method = RequestMethod.POST)
    public int deleteScenic(@PathVariable int id){
        return scenicService.deleteScenic(id);
    }
}
