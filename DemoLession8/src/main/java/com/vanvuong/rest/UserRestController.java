/**
 * 
 */
package com.vanvuong.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
