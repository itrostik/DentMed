package ru.kpfu.itis.sergeev.Dto;

import java.util.Date;

public class PostDto {
    private String title;
    private String content;
    private int authorId;
    private int postId;
    private Date date;


    public PostDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PostDto(String title, String content, int postId, int authorId, Date date) {
        this.title = title;
        this.content = content;
        this.postId = postId;
        this.authorId = authorId;
        this.date = date;
    }
}
