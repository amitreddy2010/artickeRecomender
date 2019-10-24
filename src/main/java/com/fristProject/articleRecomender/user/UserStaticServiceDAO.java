package com.fristProject.articleRecomender.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserStaticServiceDAO {
	
	private static List<User> users = new ArrayList<>();
			
	public static int usersCount = 3;
	static{
		users.add(new User(1, "amit", new Date()));
		users.add(new User(2, "reshma", new Date()));
		users.add(new User(3, "pratyu", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for (User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
//		Iterator iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
