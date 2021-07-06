/**
 * 
 */
package com.vanvuong.validation;

import javax.validation.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.vanvuong.model.User;

/**
 * @author Admin
 *
 */
@Component
public class UserAddValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		
		if (user.getUserName()==null||user.getUserName().length()==0)
		{
			errors.rejectValue("userName", "vui long nhap lai userName tu dinh nghia");
		}
		
		
	}

}
