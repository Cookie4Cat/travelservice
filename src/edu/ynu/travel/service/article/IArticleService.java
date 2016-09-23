package edu.ynu.travel.service.article;

import edu.ynu.travel.entity.article.ArticleEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface IArticleService {
    List<ArticleEntity> listArtcles(int page, int size);
    ArticleEntity getArticleById(int id);
}
