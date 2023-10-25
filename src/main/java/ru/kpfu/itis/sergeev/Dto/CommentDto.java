package ru.kpfu.itis.sergeev.Dto;

import java.sql.Timestamp;
import java.util.Date;

public class CommentDto {

    public int userId;
    public int postId;
    public int commentId;
    public String commentText;
    public String commentDate;
    public CommentDto() {

    }
    public CommentDto(int userId, int postId, int commentId, String commentText, String commentDate) {
        this.userId = userId;
        this.postId = postId;
        this.commentId = commentId;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
