package com.fristProject.articleRecomender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fristProject.articleRecomender.post.Post;
import com.fristProject.articleRecomender.user.PostRepository;
import com.fristProject.articleRecomender.user.User;
import com.fristProject.articleRecomender.user.UserRepository;

@SpringBootApplication
public class ArticleRecomenderApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(ArticleRecomenderApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        // Cleanup the tables
        postRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
//        userRepository.resetUserTable();
        // =======================================

        
        // Create two tags
        User user1 = new User(1,"Spring Boot");
        User user2 = new User(3,"Hibernate");
        
     // Create a Post
        Post post1 = new Post(1,"Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");
        Post post2 = new Post(4,"sample title",
                "sampleDescription",
                "Con");



        // Add post reference in the tags
        user1.getPosts().add(post1);
        user2.getPosts().add(post1);
        user2.getPosts().add(post2);
        
        // Add tag references in the post
//        post1.getUsers().add(user1);
//        post1.getUsers().add(user2);
//        post2.getUsers().add(user2);

        

        userRepository.save(user1);
        userRepository.save(user2);

//        userRepository.delete(user2);
        // =======================================
    }

}
