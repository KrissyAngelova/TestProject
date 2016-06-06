package org.springboot.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.model.Event;
import org.springboot.model.Gift;
import org.springboot.model.User;
import org.springboot.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftController {

	@Autowired
	GiftService giftService;
	
	@RequestMapping(
			value = "/AddGift",
			method = RequestMethod.POST
			)
	public void addGift(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		String name =  request.getParameter("name");
		String description =  request.getParameter("description");
		Event event = (Event) request.getSession().getAttribute("event");
		Gift gift = new Gift(name, description, event);
		Gift newGift = giftService.create(gift);
		if(newGift != null){
			request.getSession().setAttribute("addGiftMessage", "Gift was added successfully!");
			
		}
		else{
			request.getSession().setAttribute("addGiftMessage","Oops! Couldn't add the gift!Please try again!" );
		}
		response.sendRedirect("/addGiftPage");
		
	}
	
	@RequestMapping(
			value = "/deleteGift/{id}",
			method = RequestMethod.POST
			)
	public void deleteEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Gift gift = giftService.findOne(id);
		if(gift.getBuyer() == null)
			giftService.delete(id);
		else
			request.getSession().setAttribute("deleteErrorMessage", "Cannot delete a gift that is already taken!");
		response.sendRedirect("/eventInfoPage");
	}
	
	@RequestMapping(
			value = "/UpdateGift/{id}",
			method = RequestMethod.POST
			)
	public void updateGift(@PathVariable("id") Long id,Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		
		Gift gift = giftService.findOne(id);
		String name =  request.getParameter("name");
		String description =  request.getParameter("description");
		gift.setName(name);
		gift.setDescription(description);
		
		Gift updatedGift = giftService.update(gift);
		if(updatedGift != null){
			request.getSession().setAttribute("updateGiftMessage", "Gift was updated successfully!");
		}
		else{
			request.getSession().setAttribute("updateGiftMessage","Oops! Couldn't update an gift!Please try again!" );
		}
		response.sendRedirect("/openUpdateGiftPage/"+updatedGift.getId());
	}
	
	@RequestMapping(
			value = "/openUpdateGiftPage/{id}",
			method = RequestMethod.GET
			)
	public void openUpdateEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Gift gift = giftService.findOne(id);
		if(gift.getBuyer() == null){
			request.getSession().setAttribute("gift", gift);
			response.sendRedirect("/updateGift");
		}
		else{
			request.getSession().setAttribute("deleteErrorMessage", "Cannot update gift that is already taken!");
			Event e = (Event) request.getSession().getAttribute("event");
			response.sendRedirect("/openEvent/"+e.getId());
		}
	}
}