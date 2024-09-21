package com.htc.music.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.music.model.User;





@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer> {
	
	
	
}
