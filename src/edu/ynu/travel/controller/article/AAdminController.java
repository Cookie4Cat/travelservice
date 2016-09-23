package edu.ynu.travel.controller.article;

import edu.ynu.travel.entity.article.ArticleEntity;
import edu.ynu.travel.service.article.IArticleService;
import edu.ynu.travel.service.article.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    public ArticleEntity getArticleDetail(@PathVariable int id){
        return articleService.getArticleById(id);
    }
}
