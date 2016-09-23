package edu.ynu.travel.service.article.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.article.ArticleEntity;
import edu.ynu.travel.mapper.article.ArticleEntityMapper;
import edu.ynu.travel.service.article.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource(name = "ArticleMapper")
    private ArticleEntityMapper articleMapper;

    @Override
    public List<ArticleEntity> listArtcles(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        return articleMapper.selectAll(pageBounds);
    }

    @Override
    public ArticleEntity getArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
