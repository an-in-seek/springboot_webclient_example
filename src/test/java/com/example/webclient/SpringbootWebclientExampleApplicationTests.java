package com.example.webclient;

import com.example.webclient.post.client.PostClient;
import com.example.webclient.post.dto.PostResponse;
import com.example.webclient.user.client.UserClient;
import com.example.webclient.user.dto.UserResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootWebclientExampleApplicationTests {

    @Autowired
    private UserClient userClient;

    @Autowired
    private PostClient postClient;

    @Test
    void contextLoads() {
        // 테스트할 User ID
        final long userId = 7;

        // User ID가 7인 사용자 정보 조회
        UserResponse user = userClient.getUser(userId).block();
        System.out.println(user);

        // User ID가 7인 사용자가 작성한 Post 정보 조회
        List<PostResponse> posts = postClient.getPostByUserId(userId).collectList().block();
        assert posts != null;
        posts.forEach(System.out::println);
    }

}
