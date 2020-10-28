package com.kiwisense.dal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kiwisense.dal.model.User;

@Repository
public interface UserRepository extends GenericRepository<User>{
	
//	Optional<User> findByUserName(String username);
	
	Optional<User> findByEmail(String email);

//	Boolean existsByUserName(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "select object_id from user_info where email = ?1", nativeQuery = true)
	public Long findUserIdByEmail(String email);

}
