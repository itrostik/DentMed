package ru.kpfu.itis.sergeev.Dto;

public class MessageDto {

    public int userId;
    public int messageId;
    public String messageText;
    public String messageDate;

    public MessageDto() {

    }
    public MessageDto(int userId, int messageId, String messageText, String messageDate) {
        this.userId = userId;
        this.messageId = messageId;
        this.messageText = messageText;
        this.messageDate = messageDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}

