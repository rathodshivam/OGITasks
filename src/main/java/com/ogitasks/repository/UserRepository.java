package com.ogitasks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ogitasks.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

//	User findByUsername(String username);

	User findByEmail(String email);

	User findByEmailAndEnabled(String username, boolean enabled);

//	List<User> findByPhone(String email);
//
//	Optional<User> findById(String id);

}
