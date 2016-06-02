package org.springboot.repository;

import org.springboot.model.Event;
import org.springboot.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>  {

}
