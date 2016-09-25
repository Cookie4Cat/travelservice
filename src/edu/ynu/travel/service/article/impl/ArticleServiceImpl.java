package edu.ynu.travel.service.article.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.article.ArticleEntity;
import edu.ynu.travel.mapper.article.ArticleEntityMapper;
import edu.ynu.travel.message.article.ArticleList;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.service.article.IArticleService;
import edu.ynu.travel.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Resource(name = "ArticleMapper")
    private ArticleEntityMapper articleMapper;

    @Override
    public ArticleList listArtcles(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<ArticleEntity> articles = articleMapper.selectAll(pageBounds);
        PageList pageList = (PageList) articles;
        int count = pageList.getPaginator().getTotalCount();
        return new ArticleList(articles,count);
    }

    @Override
    public ArticleEntity getArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArticleEntity addArticle(MultipartFile file, String path, ArticleEntity articleEntity) {
        String fileName = FileUtil.saveFile(path,file);
        String url = "/upload/"+fileName;
        articleEntity.setImageUrl(url);
        return articleMapper.insertSelective(articleEntity)==1 ? articleEntity : null;
    }

    @Override
    public SimpleResponse updateArticle(int id,MultipartFile file, String path, ArticleEntity articleEntity) {
        ArticleEntity articlePre = articleMapper.selectByPrimaryKey(id);
        String urlPre =FileUtil.PATH + articlePre.getImageUrl();
        File filePre = new File(urlPre);
        filePre.delete();
        String fileName = FileUtil.saveFile(path,file);
        String url = "/upload/"+fileName;
        articleEntity.setImageUrl(url);
        return articleMapper.updateByPrimaryKeySelective(articleEntity)==1 ? new SimpleResponse("更新成功","success") : new SimpleResponse("更新失败","fail");
    }

    @Override
    public SimpleResponse deleteArticle(int id) {
        ArticleEntity articlePre = articleMapper.selectByPrimaryKey(id);
        String urlPre =FileUtil.PATH + articlePre.getImageUrl();
        File filePre = new File(urlPre);
        filePre.delete();
        return articleMapper.deleteByPrimaryKey(id)==1 ?new SimpleResponse("删除成功","success"):new SimpleResponse("删除失败","fail");
    }
}
