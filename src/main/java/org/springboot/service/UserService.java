package org.springboot.service;

import java.util.Collection;
import org.springboot.model.User;

public interface UserService {

	Collection<User> findAll();
	User findOne(Long id);
	User create(User user);
	User update(User user);
	boolean isUserExists(String username, String password);
	boolean isUsernameTaken(String username);
	void delete(Long id);
}
