package org.springboot.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.model.Event;
import org.springboot.model.User;
import org.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class UserServiceBean implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public Collection<User> findAll() {
		Collection<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User findOne(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
	
	
	 @Override
	 @Transactional(
	            propagation = Propagation.REQUIRED,
	            readOnly = false)
	public User create(User user) {
		logger.info("> create");
  
		if(user.getId() != null){
			logger.error(
                    "Attempted to create a User, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		User savedUser = userRepository.save(user);
		
		logger.info("< create");
		return savedUser;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public User update(User user) {
		logger.info("> update id:{}", user.getId());

		User userToUpdate = findOne(user.getId());
        if (userToUpdate == null) {
           
            logger.error(
                    "Attempted to update a gift, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
        }

        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setMyEvents(user.getMyEvents());
        User updatedUser = userRepository.save(userToUpdate);

        logger.info("< update id:{}", user.getId());
        return updatedUser;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public void delete(Long id) {
		 logger.info("> delete id:{}", id);

	        userRepository.delete(id);

	        logger.info("< delete id:{}", id);
		
	}

	@Override
	public boolean isUserExists(String username, String password) {
	
		User u = userRepository.findByUsername(username);
		if(u != null && u.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isUsernameTaken(String username) {
		User u = userRepository.findByUsername(username);
		if(u != null){
			return true;
		}
		return false;
	}

	@Override
	public User findByUsername(String username) {
		User u = userRepository.findByUsername(username);
		return u;
	}

	@Override
	public Collection<User> findByUsernameContaining(String name) {
		Collection<User> users = userRepository.findByUsernameContaining(name);
		return users;
	}

	
}
