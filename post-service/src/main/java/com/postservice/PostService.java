package com.postservice;

import org.springframework.stereotype.Service;

/**
 * @author Dominik_Janiga
 */
@Service
class PostService {

    private final PostRepository postRepository;

    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post postToSave = postRequestDto.toPost();
        Post savedPost = this.postRepository.save(postToSave);
        return savedPost.toResponseDto();
    }

    PostResponseDto getPost(long userId) {
        Post foundPost = this.postRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        return foundPost.toResponseDto();
    }

    void deletePost(long userId) {
        this.postRepository.deleteById(userId);
    }

    PostResponseDto updatePost(long postId, PostRequestDto postRequestDto) {
        Post post = this.postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        post.setText(postRequestDto.text());
        post.setTopic(postRequestDto.topic());
        this.postRepository.save(post);
        return post.toResponseDto();
    }
}
