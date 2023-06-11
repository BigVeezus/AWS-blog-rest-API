package com.springboot.blogAPI.service;

import com.springboot.blogAPI.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
}
