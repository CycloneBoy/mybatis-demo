package com.cycloneboy.mybatis.entity;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
public class Comments {
    private int id;
    private String commIp;
    private String comment;
    private int articleId;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommIp() {
        return commIp;
    }

    public void setCommIp(String commIp) {
        this.commIp = commIp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commIp='" + commIp + '\'' +
                ", comment='" + comment + '\'' +
                ", articleId=" + articleId +
                ", date='" + date + '\'' +
                '}';
    }
}
