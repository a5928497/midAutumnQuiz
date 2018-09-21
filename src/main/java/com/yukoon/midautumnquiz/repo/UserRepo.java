package com.yukoon.midautumnquiz.repo;

import com.yukoon.midautumnquiz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {
	@Query("select u from User u where u.username = :username")
	public User findByUsername(@Param("username")String username);
}
