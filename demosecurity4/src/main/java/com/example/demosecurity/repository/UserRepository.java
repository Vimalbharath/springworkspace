package com.example.demosecurity.repository;


import com.example.demosecurity.entity.User;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 

import java.util.Optional; 

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username); 
	
}
