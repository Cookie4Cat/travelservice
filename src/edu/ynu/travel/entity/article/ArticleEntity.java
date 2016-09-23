package edu.ynu.travel.entity.article;

import java.util.Date;

public class ArticleEntity {

    private Integer id;

    private String title;

    private String publisher;

    private String articleType;

    private Date creatAt;

    private String article;

    private String imageUrl;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getPublisher() {
        return publisher;
    }


    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }


    public String getArticleType() {
        return articleType;
    }


    public void setArticleType(String articleType) {
        this.articleType = articleType == null ? null : articleType.trim();
    }


    public Date getCreatAt() {
        return creatAt;
    }


    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }


    public String getArticle() {
        return article;
    }


    public void setArticle(String article) {
        this.article = article;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}