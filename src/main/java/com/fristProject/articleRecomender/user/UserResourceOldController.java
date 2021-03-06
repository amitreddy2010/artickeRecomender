package com.fristProject.articleRecomender.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

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


@RestController
public class UserResourceOldController {

//	@Autowired
//	private UserStaticServiceDAO service;
	
//	@GetMapping(path="/users")
//	public List<User> getAllUsers() {
//		return service.findAll();
//	}
//	
//	@GetMapping(path="/users/{id}")
//	public Resource<User> getAllUsers(@PathVariable int id) {
//		
//		User user = service.findOne(id);
//		if (user == null) {
//			throw new UserNotFoundException("id" + id);
//		}
//		
//		//HateOAS
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
//		resource.add(linkTo.withRel("all-users"));
//		return resource;
//	}
//	
//	@DeleteMapping(path="/users/{id}")
//	public void deleteUser(@PathVariable int id) {
//		
//		User user = service.deleteById(id);
//		if (user == null) {
//			throw new UserNotFoundException("id" + id);
//		}
//	}
//	
//	@PostMapping(path="/users")
//	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
//		User savedUser =  service.saveUser(user);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
//		
//		return ResponseEntity.created(location).build();
//	}
	
	
//	@GetMapping(path="/users")
//	public User getAllUsers(@PathVariable String name) {
//		return new HelloWorldBean(String.format("This is hello World Bean %s", name));
//	}
	
}
