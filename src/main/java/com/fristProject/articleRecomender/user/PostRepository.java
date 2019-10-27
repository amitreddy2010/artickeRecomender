package com.fristProject.articleRecomender.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fristProject.articleRecomender.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
}
