package org.springboot.web.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.model.Event;
import org.springboot.model.User;
import org.springboot.service.EventService;
import org.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BaseController {

	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(
            value = "/",
            method = RequestMethod.GET
            )
	public ModelAndView wellcomePage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	} 
	
	@RequestMapping(
            value = "/reg",
            method = RequestMethod.GET
            )
	public ModelAndView regPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reg");
		return mav;
	} 
	
	@RequestMapping(
            value = "/loggedUserPage",
            method = RequestMethod.GET
            )
	public ModelAndView loggedUserPage(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loggedUserPage");
		String username = (String) request.getSession().getAttribute("username");
		User u = userService.findByUsername(username);
		request.getSession().setAttribute("user", u);
		request.getSession().setAttribute("username", u.getUsername());
		request.getSession().setAttribute("myEvents", u.getMyEvents());
		return mav;
	} 
	
	@RequestMapping(
            value = "/createEvent",
            method = RequestMethod.GET
            )
	public ModelAndView createEventPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createEvent");
		return mav;
	}
	
	@RequestMapping(
            value = "/eventInfoPage",
            method = RequestMethod.GET
            )
	public ModelAndView eventInfoPage(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("eventInfoPage");
		Event e = (Event) request.getSession().getAttribute("event");
		Event updatedEvent = eventService.findOne(e.getId());
		request.getSession().setAttribute("event", updatedEvent);
		request.getSession().setAttribute("wantedGifts", updatedEvent.getWantedGifts());
		return mav;
	}
	
	@RequestMapping(
            value = "/otherEventInfoPage",
            method = RequestMethod.GET
            )
	public ModelAndView otherEventInfoPage(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("otherEventInfoPage");
		Event e = (Event) request.getSession().getAttribute("event");
		Event updatedEvent = eventService.findOne(e.getId());
		request.getSession().setAttribute("event", updatedEvent);
		request.getSession().setAttribute("wantedGifts", updatedEvent.getWantedGifts());
		return mav;
	}
	
	@RequestMapping(
            value = "/otherEventInfoPage2",
            method = RequestMethod.GET
            )
	public ModelAndView otherEventInfoPage2(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("otherEventInfoPage2");
		Event e = (Event) request.getSession().getAttribute("event");
		Event updatedEvent = eventService.findOne(e.getId());
		request.getSession().setAttribute("event", updatedEvent);
		request.getSession().setAttribute("wantedGifts", updatedEvent.getWantedGifts());
		return mav;
	}
	
	@RequestMapping(
            value = "/Logout",
            method = RequestMethod.POST
            )
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setDateHeader("Expires", 0); // Proxies.
	    response.sendRedirect("/");
	}
	
	@RequestMapping(
			value = "/updateGift",
			method = RequestMethod.GET
			)
	public ModelAndView eventGiftPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateGift");
		return mav;
	}
	
	@RequestMapping(
			value = "/updateEvent",
			method = RequestMethod.GET
			)
	public ModelAndView eventUpdatePage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateEvent");
		return mav;
	}
	
	@RequestMapping(
			value = "/addGiftPage",
			method = RequestMethod.GET
			)
	public ModelAndView addGift(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addGift");
		return mav;
	}
	
	@RequestMapping(
			value = "/searchedUsers",
			method = RequestMethod.GET
			)
	public ModelAndView searchedUsers(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchedUsers");
		return mav;
	}
	
	@RequestMapping(
			value = "/searchedEvents",
			method = RequestMethod.GET
			)
	public ModelAndView searchedEvents(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchedEvents");
		return mav;
	}
	
	@RequestMapping(
            value = "/Search",
            method = RequestMethod.POST
            )
	public void Search(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String searchedItem = request.getParameter("choice");
		request.getSession().setAttribute("searchedName", name);
		if(searchedItem.equalsIgnoreCase("user")){
			response.sendRedirect("/UserSearch");
		}
		else{
			response.sendRedirect("/EventSearch");
		}
	}
	
	@RequestMapping(
			value = "/profile",
			method = RequestMethod.GET
			)
	public ModelAndView profilePage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profile");
		return mav;
	}
}
