package org.springboot.service;

import java.util.Collection;
import org.springboot.model.User;

public interface UserService {

	Collection<User> findAll();
	User findOne(Long id);
	User create(User greeting);
	User update(User greeting);
	void delete(Long id);
}
