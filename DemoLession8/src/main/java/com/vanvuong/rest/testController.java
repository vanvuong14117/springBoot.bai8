/**
 * 
 */
package com.vanvuong.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanvuong.model.User;
import com.vanvuong.service.UserSevice;

/**
 * @author Admin
 *
 */
@RestController
public class testController {
	@Autowired
	UserSevice userSevice;
	
	@GetMapping("user")
	public List<User> getalluserREST()
	{
		return userSevice.getAllUser();
	}
}
