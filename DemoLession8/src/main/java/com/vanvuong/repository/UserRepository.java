/**
 * 
 */
package com.vanvuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vanvuong.model.User;

/**
 * @author Admin
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user where username like %?1%", nativeQuery = true)
	List<User> getByName(String searchValue);
	@Query(value = "select count(username) from user where username = ?1",nativeQuery = true)
	int checkInitByName(String searchValue);
	
}
