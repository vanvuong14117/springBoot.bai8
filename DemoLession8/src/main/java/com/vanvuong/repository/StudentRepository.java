/**
 * 
 */
package com.vanvuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanvuong.model.Student;

/**
 * @author Admin
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
