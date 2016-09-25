package edu.ynu.travel.message.article;

import edu.ynu.travel.entity.article.ArticleEntity;

import java.util.List;


public class ArticleList {
    private List<ArticleEntity> articles;
    private int count;

    public ArticleList(List<ArticleEntity> articles, int count) {
        this.articles = articles;
        this.count = count;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
