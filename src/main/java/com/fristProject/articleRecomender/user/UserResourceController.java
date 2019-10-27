package com.fristProject.articleRecomender.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fristProject.articleRecomender.post.Post;


@RestController
public class UserResourceController {

	@Autowired
	private UserStaticServiceDAO service;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getAllUsers(@PathVariable int id) {
		
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		//HateOAS
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userRepo.deleteById(id);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser =  userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/users/{id}/posts")
	public List<Post> getAllPostsForUser(@PathVariable int id) {
		
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> savePostForUser(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOpt = userRepo.findById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		User user = userOpt.get();
		
		post.setUser(user);
		postRepo.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPost_id()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
//	@GetMapping(path="/users")
//	public User getAllUsers(@PathVariable String name) {
//		return new HelloWorldBean(String.format("This is hello World Bean %s", name));
//	}
	
}
