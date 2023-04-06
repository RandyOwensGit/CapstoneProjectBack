package randyowens.seniorproject.service;

import randyowens.seniorproject.dao.PostRepository;

public class PostService {

    // PostRepository -- Posts DAO class
    private PostRepository postRepository;

    // default constructor -- inject PostRepository
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
