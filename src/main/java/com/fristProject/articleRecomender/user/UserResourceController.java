package com.fristProject.articleRecomender.user;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResourceController {

	@Autowired
	private UserStaticServiceDAO service;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getAllUsers(@PathVariable int id) {
		
		User user = service.findOne(id);
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser =  service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
//	@GetMapping(path="/users")
//	public User getAllUsers(@PathVariable String name) {
//		return new HelloWorldBean(String.format("This is hello World Bean %s", name));
//	}
	
}
