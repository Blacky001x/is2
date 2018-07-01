package com.miroslav.is2.repository;

import com.miroslav.is2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
}
