package com.example.EcomerceCore.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> users=new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public void updateUser(User user, String id) {
		userRepository.save(user);
	}
	
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
	
	
	
	

}
