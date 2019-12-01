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
        Post post0 = new Post(0,"AllianceBernstein - American Income Portfolio - AT - SGD - Hedged - Mdis - Cash",
                "The primary investment objective of the Portfolio is to seek to provide a high level of current income consistent with preservation of capital. ",
                "1.0", "Bonds", "SGD", "Global Aggregate", "1.85%", "1.19%", "5.00%", "3.52%");
        Post post1 = new Post(1,"Fidelity Asian High Yield Fund - A - SGD - Hedged - Mdis - Cash",
                "This fund seeks a high level of current income and capital appreciation by investing primarily in high-yielding sub investment grade securities of issuers",
                "1.0", "Bonds", "SGD", "N. American Equity", "2.50%", "3.48%", "11.53%", "7.32%");
        Post post2 = new Post(2,"First State Dividend Advantage Fund - SGD - Qdis - Cash",
                "The investment objective of the First State Dividend Advantage is to provide investors with regular distributions and long-term growth from high dividend ",
                "1.0", "Equity", "SGD", "APxJ Equity", "5.32%", "7.48%", "17.66%", "11.33%");
        Post post3 = new Post(3,"Neuberger Berman High Yield Bond Fund - A - Mdis - SGD - Cash",
                "Achieve an attractive level of total return income plus capital appreciation from the high yield fixed income market.",
                "1.0", "Bonds", "SGD", "US High Yield", "1.51%", "3.29%", "9.87%", "2.92%");
        Post post4 = new Post(4,"JPMorgan IF - Global Income - A - SGD - Hedged - Dis - Cash",
                "the fund aims to provide regular income by investing primarily in a portfolio of income generating securities, globally, use of financial derivative instruments.",
                "1.0", "Equity", "SGD", "Global Aggregate", "2.28%", "4.46%", "8.50%", "4.71%");
        Post post5 = new Post(5,"JPM Global Income - A - Mth - SGD Hedged - Cash",
                "the fund aims to provide regular income by investing primarily in a portfolio of income generating securities, globally, use of financial derivative instruments.",
                "1.0", "Bonds", "SGD", "Global Balanced", "2.26%", "4.50%", "8.48%", "4.59%");
        Post post6 = new Post(6,"Jupiter Dynamic Bond Fund - L - SGD - Mdis - Cash",
                "The investment objective of the Fund is to achieve a high income with the prospect of capital growth from a portfolio of investments in global securities.",
                "1.0", "Bonds", "SGD", "Global Aggregate", "1.22%", "1.84%", "6.00%", "4.27%");


        // Add post reference in the tags
        user1.getPosts().add(post1);
        user2.getPosts().add(post1);
        user2.getPosts().add(post2);
        user3.getPosts().add(post3);
        user4.getPosts().add(post4);
        user4.getPosts().add(post6);
        user5.getPosts().add(post4);
        user6.getPosts().add(post3);

        postRepository.save(post0);
        postRepository.save(post5);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        // =======================================
    }

}
