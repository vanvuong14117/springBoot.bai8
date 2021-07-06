/**
 * 
 */
package com.vanvuong.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanvuong.model.Student;
import com.vanvuong.repository.StudentRepository;
import com.vanvuong.service.StudentSevice;

/**
 * @author Admin
 *
 */
@Service
public class StudentSeviceimpl implements StudentSevice {
	@Autowired
	StudentRepository studentReposotory;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> listStudents = new ArrayList<Student>();
		listStudents = studentReposotory.findAll();
		return listStudents;
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentReposotory.save(student);

	}

	@Override
	public Student searchStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentReposotory.getById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub

	}

}
