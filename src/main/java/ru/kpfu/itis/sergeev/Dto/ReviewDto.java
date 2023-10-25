package ru.kpfu.itis.sergeev.Dto;

public class ReviewDto {

    private String reviewText;
    private int reviewId;
    private int doctorId;
    private int userId;
    private String reviewDate;

    public ReviewDto() {
    }

    public ReviewDto(String reviewText, int reviewId, int doctorId, int userId, String reviewDate) {
        this.reviewText = reviewText;
        this.reviewId = reviewId;
        this.doctorId = doctorId;
        this.userId = userId;
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
}
