package com.fristProject.articleRecomender.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostResourceController {

	@Autowired
	private PostServiceDAO service;
	
//	@GetMapping(path="/users/{id}/posts")
//	public Post getPostsForUsersId(@PathVariable int id) {
////		return service.findOne(id);
//	}
//	
//	@PostMapping(path="/users/{id}/posts")
//	public void saveUser(@PathVariable int id, Post post) {
//		Post savedPost =  service.savePost(id, post);
////		ResponseEntity<T>.created 
//	}
	
	
}