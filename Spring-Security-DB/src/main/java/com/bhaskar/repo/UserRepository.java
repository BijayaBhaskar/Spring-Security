package com.bhaskar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);

}
