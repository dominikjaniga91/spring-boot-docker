package com.postservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dominik_Janiga
 */
@RestController
@RequestMapping("/posts")
class PostController {

    private final PostService postService;
    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public PostController(PostService postService,
                          RestTemplate restTemplate) {
        this.postService = postService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto post = this.postService.createPost(postRequestDto);
        this.restTemplate.postForObject(this.userServiceUrl + "/users/amount-of-posts", postRequestDto.authorId(), Long.class);
        return post;
    }

    @GetMapping("/{id}")
    PostResponseDto getPost(@PathVariable long id) {
        return this.postService.getPost(id);
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable long id) {
        this.postService.deletePost(id);
    }

    @PutMapping("/{id}")
    PostResponseDto updatePost(@PathVariable long id, @RequestBody PostRequestDto postRequestDto) {
        return this.postService.updatePost(id, postRequestDto);
    }
}
