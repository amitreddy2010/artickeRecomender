package com.fristProject.articleRecomender.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostServiceDAO {
	
	private static List<Post> posts = new ArrayList<>();
			
	public static int postsCount = 3;
	static{
//		posts.add(new Post(1, "amit", new Date()));
//		posts.add(new Post(2, "reshma", new Date()));
//		posts.add(new Post(3, "pratyu", new Date()));
	}
	
	public List<Post> findAll() {
		return posts;
	}
	
//	public Post savePost(Post post) {
//		if(user.getId() == null) {
//			user.setId(++usersCount);
//		}
//		users.add(user);
//		return user;
//	}
//	
//	public User findOne(int id) {
//		for (User user:users) {
//			if(user.getId() == id) {
//				return user;
//			}
//		}
//		return null;
//	}

}
