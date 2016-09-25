package edu.ynu.travel.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/24.
 */
public class FileUtil {

    public static final String PATH = "C:\\Users\\Administrator\\IdeaProjects\\tour\\WebRoot";

    public static String saveFile(String path, MultipartFile file){
        String fileName = UUID.randomUUID().toString();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //存入图片
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
