/**
 * 
 */
package com.vanvuong.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vanvuong.model.Student;
import com.vanvuong.model.User;
import com.vanvuong.repository.UserRepository;
import com.vanvuong.service.UserSevice;

/**
 * @author Admin
 *
 */
@Service
public class UserSeviceimpl implements UserSevice {
	@Autowired
	UserRepository userReposotory;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> listStudents = new ArrayList<User>();
		listStudents = userReposotory.findAll();
		return listStudents;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userReposotory.save(user);
	}

	@Override
	public User searchUser(Integer id) {
		// TODO Auto-generated method stub
		return userReposotory.getById(id);
	}

	@Override
	public void deleteByUser(User user) {
		// TODO Auto-generated method stub
		userReposotory.delete(user);
	}
	@Override
	public void deleteByIdUser(int id) {
		// TODO Auto-generated method stub
		userReposotory.deleteById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userReposotory.save(user);
		
	}
	@Override
	public void apiUpdateUser(User user) {
		// TODO Auto-generated method stub
		User a = findByIdUser(user.getId());
		if (StringUtils.hasText(user.getUserName()))
		{
			a.setUserName(user.getUserName());
		}
		if (StringUtils.hasText(user.getPassWord()))
		{
			a.setPassWord(user.getPassWord());
		}
		userReposotory.save(a);
		
	}

	@Override
	public List<User> timUser(String user) {
		// TODO Auto-generated method stub
		List<User> a =userReposotory.getByName(user);
		return a;
	}

	@Override
	public int checkInit(String name) {
		// TODO Auto-generated method stub
		int a = -1;
		 a = userReposotory.checkInitByName(name);
		return a;
	}

	@Override
	public User findByIdUser(Integer id) {
		// TODO Auto-generated method stub
		return userReposotory.findById(id).get();
	}

	@Override
	public Boolean kiemTonTaiTheoUserName(String id) {
		// TODO Auto-generated method stub
		return  userReposotory.existsByUserName(id);
	}

	
}
