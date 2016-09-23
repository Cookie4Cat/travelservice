package edu.ynu.travel.mapper.article;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.article.ArticleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ArticleMapper")
public interface ArticleEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleEntity record);

    int insertSelective(ArticleEntity record);

    ArticleEntity selectByPrimaryKey(Integer id);

    List<ArticleEntity> selectAll(PageBounds pageBounds);

    int updateByPrimaryKeySelective(ArticleEntity record);

    int updateByPrimaryKey (ArticleEntity record);

}