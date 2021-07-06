/**
 * 
 */
package com.vanvuong.service;

import java.util.List;

import com.vanvuong.model.Student;

/**
 * @author Admin
 *
 */
public interface StudentSevice {
	public List<Student> getAllStudent();

	public Student addStudent(Student student);

	public Student searchStudent(Integer id);

	public void deleteStudent(Integer id);

}
