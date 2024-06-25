package com.example.webclient.post.dto;

public record PostRequest(
    String title,
    String content,
    long userId
) {

}
