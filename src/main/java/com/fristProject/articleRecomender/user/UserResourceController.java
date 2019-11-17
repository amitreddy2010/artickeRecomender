package com.fristProject.articleRecomender.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
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
	
	@GetMapping(path="/subscriptionList")
	public List<ReccIn> getAllSubscriptionList() {
		return userRepo.subscriptionTable();
	}
	
	@GetMapping(path="/reccomendationPosts/{id}")
	public List<Post> getAllReccomendationPosts(@PathVariable int id) {
		List<ReccOut> reccList = userRepo.reccomendationsListTable();
		ReccOut reccValue = null;
		for (ReccOut value : reccList) {
	        if (Objects.equals(id, value.getUserId())) {
	        	reccValue = value;
	        	break;
	        }
	    }
		String[] values = reccValue.getReccValues().split(",");
		
		List<Post> posts =  postRepo.findAll();
		for (int i = 0; i < posts.size(); i++) {
			posts.get(i).setContent( values[i]);
	    }
		
		return posts;
	}
	
	@GetMapping(path="/reccomendationsList")
	public List<ReccOut> getAllReccomendationList() {
		return userRepo.reccomendationsListTable();
	}
	
	@GetMapping(path="/users/{id}")
	public Set<Post> getAllUsers(@PathVariable int id) {
		
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		Set<Post> posts = user.get().getPosts();
		//HateOAS
//		Resource<Post> resource = new Resource<Post>(user.get().getPosts());
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
//		resource.add(linkTo.withRel("all-users"));
		return posts;
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userRepo.deleteById(id);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		Optional<User> user1 = userRepo.findById(user.getId());
		if (user1.isPresent()) {
			throw new UserNotFoundException("id" + user.getId());
		}
		User savedUser =  userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/posts", consumes = MediaType.ALL_VALUE, produces = { "application/json", "text/json" })
	public List<Post> getAllPosts() {	
		return postRepo.findAll();
	}
	
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> savePostForUser(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOpt = userRepo.findById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		User user = userOpt.get();
		
        user.getPosts().add(post);

        userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping(path="/users/{id}/remove_post")
	public void deletePostForUser(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOpt = userRepo.findById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		User user = userOpt.get();
		
//		if(user.getPosts().contains(post)) {
		Set<Post> posts = user.getPosts();
		for (Post value : posts) {
	        if (Objects.equals(post.getId(), value.getId())) {
	        	posts.remove(value);
	        }
	    }

		user.setPosts(posts);
        userRepo.save(user);

//		}
//		else {
//			throw new UserNotFoundException("id" + id);
//		}

	}
	
//	@GetMapping(path="/users")
//	public User getAllUsers(@PathVariable String name) {
//		return new HelloWorldBean(String.format("This is hello World Bean %s", name));
//	}
	
}
