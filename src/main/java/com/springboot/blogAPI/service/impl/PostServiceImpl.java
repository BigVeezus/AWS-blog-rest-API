package com.springboot.blogAPI.service.impl;

import com.springboot.blogAPI.dto.PostDto;
import com.springboot.blogAPI.model.Post;
import com.springboot.blogAPI.repository.PostRepository;
import com.springboot.blogAPI.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    private PostDto convertToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post convertToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


    @Override
    public PostDto createPost(PostDto postDto) {

        //convert DTO to entity
        Post post = convertToEntity(postDto);

        // Save new post
        Post newPost = postRepository.save(post);

        //convert entity to PostDTO

        return convertToDTO(newPost);

    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::convertToDTO).collect(Collectors.toList());

    }



}
