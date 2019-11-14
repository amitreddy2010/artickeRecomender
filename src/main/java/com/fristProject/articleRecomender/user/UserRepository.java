package com.fristProject.articleRecomender.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
	
//    @Modifying
//    @Query("ALTER TABLE user AUTO_INCREMENT=1")
//    void resetUserTable();
	
	@Query("SELECT a FROM ReccIn a")
	List<ReccIn> subscriptionTable();
	
	@Query("SELECT a FROM ReccOut a")
	List<ReccOut> reccomendationsListTable();
}
