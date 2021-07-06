/**
 * 
 */
package com.vanvuong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanvuong.getValueFromProperties.ValueOfProperties;
import com.vanvuong.model.Student;
import com.vanvuong.model.User;
import com.vanvuong.service.UserSevice;
import com.vanvuong.validation.UserAddValidator;

/**
 * @author Admin
 *
 */
@Controller
public class UserController {
	@Autowired
	UserSevice userSevice;
	@Autowired
	UserAddValidator userAddValidator;
	@Autowired
	private ValueOfProperties valueOfProperties;

	@RequestMapping(value = { "/dangnhap" }, method = RequestMethod.GET)
	public String dangnhap(@ModelAttribute("dangNhapUserModel") User user, Model model) {
		model.addAttribute("dangNhapUserModel", new User());
		return "dangnhap";
	}
	@RequestMapping(value = { "/dangnhapUser" }, method = RequestMethod.GET)
	public String dangnhapUser(@ModelAttribute("dangNhapUserModel") User user, Model model) {
		model.addAttribute("dangNhapUserModel", new User());
		int result = -1;
		if (StringUtils.hasText(user.getUserName()) && StringUtils.hasText(user.getPassWord())) {

			result = userSevice.checkInit(user.getUserName());
		}
		if (result == 1) {
			return "home";
		}
		return "dangnhap";
	}
	

	@RequestMapping(value = { "/dangnhapByUserName" }, method = RequestMethod.GET)
	public String dangnhapUser2(Model model, @RequestParam(name = "userName", required = false) String name) {
		
		
		model.addAttribute("dangNhapUserModel", new User());
		int result = -1;
		if (StringUtils.hasText(name)) {

			result = userSevice.checkInit(name);
		}
		if (result == 1) {
			return "home";
		}
		return "dangnhap";
	}
	

	@RequestMapping(value = { "/dangky" }, method = RequestMethod.GET)
	public String dangky(@ModelAttribute("userModelTranfer") User user, Model model) {
		model.addAttribute("userModelTranfer", new User());
		return "dangky";
	}

	@RequestMapping(value = { "/dangkyUser" }, method = RequestMethod.GET)
	public String dangkyUser(@ModelAttribute("userModelTranfer") User user, Model model) {
		int result = -1;
		if (StringUtils.hasText(user.getUserName()) && StringUtils.hasText(user.getPassWord())) {

			result = userSevice.checkInit(user.getUserName());
		}
		if (result == 0) {
			userSevice.addUser(user);
			return "home";
		}
		return "dangky";
	}

	// map theo address tren trinh duyet
	@RequestMapping(value = { "/listUsers" }, method = RequestMethod.GET)
	public String getAllUser(Model model) {
		List<User> listUsers = new ArrayList<User>();
		listUsers = userSevice.getAllUser();
		model.addAttribute("listUsers", listUsers);
		// giong vs views
		return "listUsers";
	}

	// show trang add student
	@RequestMapping(value = { "/showAddUser" }, method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("userModelTranfer", new User());
		// giong vs views
		return "addUser";
	}

	// add student
	@RequestMapping(value = { "/saukhiaddUser" }, method = RequestMethod.POST)
	public String doAddUser(@Valid @ModelAttribute("userModelTranfer") User model, BindingResult errors) {

		String a = valueOfProperties.getBlankMessage();
		userAddValidator.validate(model, errors);
		if (errors.hasErrors()) {
			String b = errors.getFieldError().getCode();
			return b;
		}
		userSevice.updateUser(model);
		// giong vs views
		return "redirect:home";
	}

	// tim 1 user
	@RequestMapping(value = { "/searchTheUser/{id}" }, method = RequestMethod.GET)
	public String searchUser(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("user", userSevice.searchUser(id));
		// giong vs views
		return "UserDetails";
	}

	// delete 1 user
	@RequestMapping(value = { "/deleteByUser/{id}" }, method = RequestMethod.GET)
	public String deleteByUser(Model model, @PathVariable(name = "id") int id) {
		User userSlected = userSevice.searchUser(id);
		userSevice.deleteByUser(userSlected);
		model.addAttribute("xoathanhcong", "da xoa user thanh cong");
		getAllUser(model);
		// giong vs views
		return "listUsers";
	}

	// delete 1 user
	@RequestMapping(value = { "/deleteByIdUser/{id}" }, method = RequestMethod.GET)
	public String deleteByIdUser(Model model, @PathVariable(name = "id") int id) {
		userSevice.deleteByIdUser(id);
		model.addAttribute("xoathanhcong", "da xoa user thanh cong");
		getAllUser(model);
		// giong vs views
		return "listUsers";
	}

	// edit 1 user
	@RequestMapping(value = { "/editByIdUser/{id}" }, method = RequestMethod.GET)
	public String editByIdUser(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("userEdit", userSevice.searchUser(id));

		// giong vs views
		return "editUser";
	}

	// update 1 user
	@RequestMapping(value = { "/editByIdUser" }, method = RequestMethod.POST)
	public String updateByIdUser(@ModelAttribute("userEdit") User model) {
		userSevice.addUser(model);
		// giong vs views
		return ("redirect:home");
	}

	// tim theo model
	@RequestMapping(value = { "/searchUsers" }, method = RequestMethod.GET)
	public String getUser(Model model) {
		List<User> listUsers = new ArrayList<User>();
		listUsers = userSevice.getAllUser();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("timName", new User());

		// giong vs views
		return "searchUsers";
	}

	@RequestMapping(value = { "/doSearchUsers" }, method = RequestMethod.POST)
	public String doSearchUsers(@ModelAttribute("timName") User user, Model model1) {
		List<User> listUsers = new ArrayList<User>();

		listUsers = userSevice.timUser(user.getUserName());
		model1.addAttribute("listUsers", listUsers);
		return "searchUsers";
	}

	// tim theo param
	@RequestMapping(value = { "/searchUsers2" }, method = RequestMethod.GET)
	public String getUser2(Model model, @RequestParam(name = "searchInput", required = false) String search) {
		if (StringUtils.isEmpty(search)) {
			search = "";
		}
		List<User> listUsers = new ArrayList<User>();
		listUsers = userSevice.timUser(search);
		model.addAttribute("listUsers", listUsers);
		return "searchUsers2";
	}
}
