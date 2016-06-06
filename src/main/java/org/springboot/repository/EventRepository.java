package org.springboot.repository;

import java.util.Collection;
import java.util.Date;

import org.springboot.model.Event;
import org.springboot.model.Gift;
import org.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long>  {

	Collection<Event> findByName(String name);
	Collection<Event> findByNameContaining(String name);
}
