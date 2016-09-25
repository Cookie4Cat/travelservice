package edu.ynu.travel.service.article;

import edu.ynu.travel.entity.article.ArticleEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IArticleService {
    List<ArticleEntity> listArtcles(int page, int size);
    ArticleEntity getArticleById(int id);
    ArticleEntity addArticle(MultipartFile file, String path, ArticleEntity articleEntity);
    SimpleResponse updateArticle(int id, MultipartFile file, String path, ArticleEntity articleEntity);
    SimpleResponse deleteArticle(int id);
}
