package com.example.EcomerceCore.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
	
	public User getUserById(String id);
	public User getUserBySessionId(String sessionId);

}
