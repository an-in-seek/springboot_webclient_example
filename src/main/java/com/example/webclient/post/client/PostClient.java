package com.example.webclient.post.client;

import com.example.webclient.post.dto.PostRequest;
import com.example.webclient.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PostClient {

    private final static String BASE_URI = "/posts";
    private final WebClient webClient;

    public Mono<PostResponse> postPost(PostRequest postRequest) {
        return webClient
            .post()
            .uri(BASE_URI)
            .bodyValue(postRequest)
            .retrieve()
            .bodyToMono(PostResponse.class);
    }


    public Mono<PostResponse> putPost(long postId, PostRequest postRequest) {
        return webClient
            .put()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .bodyValue(postRequest)
            .retrieve()
            .bodyToMono(PostResponse.class);
    }


    public Mono<PostResponse> getPost(long postId) {
        return webClient
            .get()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .retrieve()
            .bodyToMono(PostResponse.class);
    }

    public Flux<PostResponse> getPostByUserId(long userId) {
        return webClient
            .get()
            .uri(uriBuilder -> uriBuilder
                .path(BASE_URI)
                .queryParam("userId", userId)
                .build())
            .retrieve()
            .bodyToFlux(PostResponse.class);
    }

    public Mono<Void> deletePost(long postId) {
        return webClient
            .delete()
            .uri(String.format("%s/%d", BASE_URI, postId))
            .retrieve()
            .bodyToMono(Void.class);
    }

}
