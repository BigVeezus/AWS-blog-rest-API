package com.springboot.blogAPI.service;

import com.springboot.blogAPI.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
