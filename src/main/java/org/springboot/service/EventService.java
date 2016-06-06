package org.springboot.service;

import java.util.Collection;
import java.util.Date;

import org.springboot.model.Event;



public interface EventService {

	Collection<Event> findAll();
	Event findOne(Long id);
	Event create(Event event);
	Event update(Event event);
	Collection<Event> findByName(String name);
	Collection<Event> findByNameContaining(String name);
	void delete(Long id);

}
