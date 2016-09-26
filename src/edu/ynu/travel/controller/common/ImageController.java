package edu.ynu.travel.controller.common;


import edu.ynu.travel.service.image.ImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Resource
    private ImageService imageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public int deleteImage(@PathVariable int id){
        return imageService.deleteImage(id);
    }
}
