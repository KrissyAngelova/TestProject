package org.springboot.service;

import java.util.Collection;

import org.springboot.model.Event;
import org.springboot.model.User;


public interface EventService {

	Collection<Event> findAll();
	Event findOne(Long id);
	Event create(Event event);
	Event update(Event event);
	void delete(Long id);
	Event findById(Long id);
}
