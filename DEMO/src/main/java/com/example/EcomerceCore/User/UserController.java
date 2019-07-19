package com.example.EcomerceCore.User;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	/**
	 * Gets the post request body and 
	 * creates an instance of the body
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user,HttpSession session ) {
		user.setSessionId(session.getId());
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void addUser(@RequestBody User user,@PathVariable String id) {
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void addUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
		//omg change
	
	@PostMapping("/users/closeSession/{userId}")
	public void destroySession(HttpServletRequest request,String sessionId) {
		User user =userService.getUserBySessionId(sessionId);
		user.setSessionId("closed");
		userService.updateUser(user);
		if (request.getSession().getId().equalsIgnoreCase(sessionId)) {
			request.getSession().invalidate();
		}
		
		
	}
	

}
