package org.springboot.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.model.Event;
import org.springboot.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class EventServiceBean implements EventService{


	@Autowired
	private EventRepository eventRepository;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public Collection<Event> findAll() {
		Collection<Event> events = eventRepository.findAll();
		return events;
	}

	@Override
	public Event findOne(Long id) {
		Event event = eventRepository.findOne(id);
		return event;
	}

	@Override
	 @Transactional(
	            propagation = Propagation.REQUIRED,
	            readOnly = false)
	public Event create(Event event) {
		logger.info("> create");
  
		if(event.getId() != null){
			logger.error(
                    "Attempted to create a User, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		Event savedEvent = eventRepository.save(event);
		logger.info("< create");
		return savedEvent;
	}

	@Override
	public Event update (Event event) {
		logger.info("> update id:{}", event.getId());

		Event eventToUpdate = findOne(event.getId());
        if (eventToUpdate == null) {
           
            logger.error(
                    "Attempted to update a gift, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
        }

        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setDate(event.getDate());
        eventToUpdate.setWantedGifts(event.getWantedGifts());
  
        Event updatedEvent = eventRepository.save(eventToUpdate);

        logger.info("< update id:{}", event.getId());
        return updatedEvent;
	}

	@Override
	public void delete(Long id) {
		 logger.info("> delete id:{}", id);

	     eventRepository.delete(id);

	     logger.info("< delete id:{}", id);
	}
}
