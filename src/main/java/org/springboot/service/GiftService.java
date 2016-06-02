package org.springboot.service;

import java.util.Collection;

import org.springboot.model.Gift;

public interface GiftService {

	Collection<Gift> findAll();
	Gift findOne(Long id);
	Gift create(Gift gift);
	Gift update(Gift gift);
	void delete(Long id);
}
