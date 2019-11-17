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
        User user1 = new User(0,"Amit");
        User user2 = new User(1,"Suresh");
        User user3 = new User(2,"Bob");
        User user4 = new User(3,"Justin");
        User user5 = new User(4,"nikhil");
        User user6 = new User(5,"Sandip");
        
     // Create a Post
        Post post1 = new Post(1,"DBS Holdings",
                "DBS Group Holdings Limited and its subsidiaries provide a variety of financial services. ",
                "1.0");
        Post post2 = new Post(4,"Patamar Capital",
                "Patamar Capital exists to unlock better economic opportunities for Asia’s low-income communities. ",
                "1.0");
        Post post3 = new Post(6,"Capital IQ",
                "The S&P Capital IQ platform combines deep and broad global financial intelligence with an array of tools for analysis.",
                "1.0");


        // Add post reference in the tags
        user1.getPosts().add(post1);
        user2.getPosts().add(post1);
        user2.getPosts().add(post2);
        user6.getPosts().add(post3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        // =======================================
    }

}
