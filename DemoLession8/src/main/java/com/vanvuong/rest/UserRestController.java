/**
 * 
 */
package com.vanvuong.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vanvuong.model.User;
import com.vanvuong.service.UserSevice;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	UserSevice sevice;
	// get post put delete

	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> a = sevice.getAllUser();
		return a;

	}

	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") int id) {

		return sevice.findByIdUser(id);

	}

	@GetMapping("/users/param")
	public User getUserByIdParam(@RequestParam(name = "userId") int id) {

		return sevice.findByIdUser(id);

	}
	
	@GetMapping("/searchUser")
	public ResponseEntity<List<User>> searchUser(@RequestParam(name = "userNameSearch") String username) {
		List<User> a =  sevice.timUser(username);
		return new ResponseEntity(a, HttpStatus.OK);
	}
	
	@GetMapping("/searchUser2")
	public List<User> searchUser2(@RequestParam(name = "userNameSearch2") String username) {
		List<User> a =  sevice.timUser(username);
		return a;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User a =  sevice.addUser(user);
		return new ResponseEntity<User>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam ("id") int id) {
		sevice.deleteByIdUser(id);
		return "Success";
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		sevice.apiUpdateUser(user);
		return "Success";
	}
	
	
}
