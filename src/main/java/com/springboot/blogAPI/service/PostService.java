package com.springboot.blogAPI.service;

import com.springboot.blogAPI.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getOnePost(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    String deletePost(Long id);
}
