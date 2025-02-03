package com.example.demo.dto;

public class MessageRequest {
    private String content;

    public MessageRequest(String content) {
        this.content = content;
    }

    public MessageRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
