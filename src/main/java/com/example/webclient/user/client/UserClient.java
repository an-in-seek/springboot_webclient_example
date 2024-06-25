package com.example.webclient.user.client;

import com.example.webclient.user.dto.UserRequest;
import com.example.webclient.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final static String BASE_URI = "/users";
    private final WebClient webClient;

    public Mono<UserResponse> postUser(UserRequest userRequest) {
        return webClient
            .post()
            .uri(BASE_URI)
            .bodyValue(userRequest)
            .retrieve()
            .bodyToMono(UserResponse.class);
    }


    public Mono<UserResponse> putUser(long userId, UserRequest userRequest) {
        return webClient
            .put()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .bodyValue(userRequest)
            .retrieve()
            .bodyToMono(UserResponse.class);
    }


    public Mono<UserResponse> getUser(long userId) {
        return webClient
            .get()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .retrieve()
            .bodyToMono(UserResponse.class);
    }

    public Mono<Void> deleteUser(long userId) {
        return webClient
            .delete()
            .uri(String.format("%s/%d", BASE_URI, userId))
            .retrieve()
            .bodyToMono(Void.class);
    }

}
