package edu.ynu.travel.controller.article;

import edu.ynu.travel.entity.article.ArticleEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.article.IArticleService;
import edu.ynu.travel.service.article.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/article/admin")
public class AAdminController {
    @Resource
    private IArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public List<ArticleEntity> getAllArticle(@RequestParam(name = "page") int page,
                                             @RequestParam(name = "size") int size){
        return articleService.listArtcles(page,size);
    }

    @RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    public ArticleEntity getArticleDetail(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ArticleEntity addArticle(@RequestParam(value = "file", required = false)MultipartFile file, HttpServletRequest request,
                                    ArticleEntity articleEntity){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return articleService.addArticle(file,path,articleEntity);
    }

    @RequestMapping(value = "articles/{id}", method = RequestMethod.POST)
    public SimpleResponse updateArticle(@PathVariable int id,@RequestParam(value = "file", required = false)MultipartFile file,
                                        HttpServletRequest request,ArticleEntity articleEntity){
        String path = request.getSession().getServletContext().getRealPath("upload");
        articleEntity.setId(id);
        return articleService.updateArticle(id,file,path,articleEntity);
    }

    @RequestMapping(value = "articles/{id}",method = RequestMethod.DELETE)
    public SimpleResponse deleteArticle(@PathVariable int id){
        return articleService.deleteArticle(id);
    }
}
