# 프로젝트 개요

이 프로젝트는 사용자와 게시물 관리를 위한 WebClient 기반의 클라이언트 클래스를 포함하고 있습니다. `UserClient`는 사용자 엔드포인트와 통신하고, `PostClient`는 게시물 엔드포인트와 통신합니다. 각 클래스는 CRUD 작업을 수행하는 메서드를
제공합니다.

## 구성 요소

### UserClient

`UserClient` 클래스는 `/users` 엔드포인트에 대해 CRUD 작업을 수행합니다. 주요 메서드는 다음과 같습니다:

- `postUser(UserRequest userRequest)`: 새로운 사용자를 생성합니다.
- `putUser(long userId, UserRequest userRequest)`: 기존 사용자를 업데이트합니다.
- `getUser(long userId)`: 특정 사용자의 정보를 가져옵니다.
- `deleteUser(long userId)`: 특정 사용자를 삭제합니다.

### PostClient

`PostClient` 클래스는 `/posts` 엔드포인트에 대해 CRUD 작업을 수행합니다. 주요 메서드는 다음과 같습니다:

- `postPost(PostRequest postRequest)`: 새로운 게시물을 생성합니다.
- `putPost(long postId, PostRequest postRequest)`: 기존 게시물을 업데이트합니다.
- `getPost(long postId)`: 특정 게시물의 정보를 가져옵니다.
- `getPostByUserId(long userId)`: 특정 사용자가 작성한 모든 게시물을 가져옵니다.
- `deletePost(long postId)`: 특정 게시물을 삭제합니다.

## 의존성

이 프로젝트는 다음 의존성을 필요로 합니다:

- Spring WebFlux
- Lombok

## 사용법

프로젝트를 사용하려면, `WebClient`를 주입받아 `UserClient`와 `PostClient` 인스턴스를 생성합니다. 예를 들어, Spring Boot 애플리케이션에서 다음과 같이 사용할 수 있습니다:

```java

@Autowired
private UserClient userClient;

@Autowired
private PostClient postClient;
```

그런 다음, 각 메서드를 호출하여 사용자와 게시물에 대한 CRUD 작업을 수행할 수 있습니다. 예를 들어:

```java
UserRequest userRequest = new UserRequest(/* 사용자 정보 설정 */);
userClient.postUser(userRequest)
    .subscribe(response -> System.out.println("사용자 생성: " + response));

PostRequest postRequest = new PostRequest(/* 게시물 정보 설정 */);
postClient.postPost(postRequest)
    .subscribe(response -> System.out.println("게시물 생성: " + response));

```

## 주의사항

- WebClient 호출은 비동기적으로 수행되며, `Mono`와 `Flux`를 사용하여 결과를 처리합니다.
- 적절한 오류 처리를 구현해야 합니다.
- Lombok을 사용하여 생성자와 필드 주입을 간편하게 합니다.