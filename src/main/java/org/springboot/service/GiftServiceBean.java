package org.springboot.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.model.Event;
import org.springboot.model.Gift;
import org.springboot.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class GiftServiceBean implements GiftService {

	@Autowired
	private GiftRepository giftRepository;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Collection<Gift> findAll() {
		Collection<Gift> gifts = giftRepository.findAll();
		return gifts;
	}

	@Override
	public Gift findOne(Long id) {
		Gift gift = giftRepository.findOne(id);
		return null;
	}

	@Override
	@Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
	public Gift create(Gift gift) {
		logger.info("> create");
		  
		if(gift.getId() != null){
			logger.error(
                    "Attempted to create a User, but id attribute was not null.");
            throw new EntityExistsException(
                    "The id attribute must be null to persist a new entity.");
		}
		Gift savedGift = giftRepository.save(gift);
		logger.info("< create");
		return savedGift;
	}

	@Override
	public Gift update(Gift gift) {
		logger.info("> update id:{}", gift.getId());

        Gift giftToUpdate = findOne(gift.getId());
        if (giftToUpdate == null) {
           
            logger.error(
                    "Attempted to update a gift, but the entity does not exist.");
            throw new NoResultException("Requested entity not found.");
        }

        giftToUpdate.setName(gift.getName());
        giftToUpdate.setDescription(gift.getDescription());
        giftToUpdate.setTaken(gift.isTaken());
        giftToUpdate.setBuyer(gift.getBuyer());
        Gift updatedGift = giftRepository.save(giftToUpdate);

        logger.info("< update id:{}", gift.getId());
        return updatedGift;
	}

	@Override
	public void delete(Long id) {
		 logger.info("> delete id:{}", id);

	        giftRepository.delete(id);

	        logger.info("< delete id:{}", id);
		
	}

	
}
