/**
 * 
 */
package com.vanvuong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanvuong.model.Student;
import com.vanvuong.service.StudentSevice;

/**
 * @author Admin
 *
 */
@Controller
public class StudentController {
	@Autowired
	StudentSevice studentSevice;

	// map theo address tren trinh duyet
	@RequestMapping(value = { "/listStudents" }, method = RequestMethod.GET)
	public String getAllStudent(Model model) {
		List<Student> listStudents = new ArrayList<Student>();
		listStudents = studentSevice.getAllStudent();
		model.addAttribute("listStudents", listStudents);
		// giong vs views
		return "listStudents";
	}
	// show trang add student
	@RequestMapping(value = { "/showAddStudent" }, method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("studentModelTranfer", new Student());
		// giong vs views
		return "addStudent";
	}
	
	// add student
	@RequestMapping(value = { "/addStudent" }, method = RequestMethod.POST)
	public String doAddStudent(@ModelAttribute("studentModelTranfer") Student model) {
		studentSevice.addStudent(model);
		// giong vs views
		return "home";
	}
	
	// tim 1 student
	@RequestMapping(value = { "/searchTheStudent/{id}" }, method = RequestMethod.GET)
	public String searchStudent(Model model,@PathVariable(name = "id") int id) {
		model.addAttribute("student",studentSevice.searchStudent(id));
		// giong vs views
		return "StudentDetail";
	}
}
