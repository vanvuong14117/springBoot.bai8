/**
 * 
 */
package com.vanvuong.service;

import java.util.List;

import com.vanvuong.model.User;


/**
 * @author Admin
 *
 */
public interface UserSevice {
	public List<User> getAllUser();

	public User addUser(User user);

	public User searchUser(Integer id);

	public void deleteByUser(User user);
	
	public void deleteByIdUser(int id);
	
	public void updateUser(User user);
	
	public List<User> timUser(String user);
	
	public int checkInit(String name);
	
	public User findByIdUser(Integer id);
}
