package com.endTerm.EndTerm.service;

import com.endTerm.EndTerm.model.Post;
import com.endTerm.EndTerm.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {



    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.getAllPosts();
    }

    public void createPost(Post newPost){
        postRepository.createPost(newPost);
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }

    public Post getPost(Integer postId) {
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        postRepository.updatePost(updatedPost);
    }
}

