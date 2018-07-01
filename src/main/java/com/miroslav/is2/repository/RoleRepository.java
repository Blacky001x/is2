package com.miroslav.is2.repository;

import com.miroslav.is2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRole(String role);
	
}
