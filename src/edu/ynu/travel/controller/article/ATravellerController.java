package edu.ynu.travel.controller.article;

import edu.ynu.travel.message.article.ArticleList;
import edu.ynu.travel.service.article.IArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/article/traveler")
public class ATravellerController {
    @Resource
    private IArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ArticleList getAllArticle(@RequestParam(name = "page") int page,
                                     @RequestParam(name = "size") int size){
        return articleService.listArtcles(page,size);
    }
}
