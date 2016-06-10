package org.springboot.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.model.Event;
import org.springboot.model.User;
import org.springboot.service.EventService;
import org.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

	@Autowired
	EventService eventService;
	
	@RequestMapping(
			value = "/CreateEvent",
			method = RequestMethod.POST
			)
	public void CreateEvent(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		String name =  request.getParameter("name");
		String description =  request.getParameter("description");
		String str = request.getParameter("date");
		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		Date date = formatter.parse(str);
		User u = (User) request.getSession().getAttribute("user");
		Event e = new Event(name, description, date ,u);
		Event newEvent = eventService.create(e);
		if(newEvent != null){
			request.getSession().setAttribute("createEventMessage", "Event was created successfully!");
			
		}
		else{
			request.getSession().setAttribute("createEventMessage","Oops! Couldn't make an event!Please try again!" );
		}
		response.sendRedirect("/createEvent");
		
	}
	
	@RequestMapping(
			value = "/openEvent/{id}",
			method = RequestMethod.GET
			)
	public void openEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		Event e = eventService.findOne(id);
		request.getSession().setAttribute("event", e);
		request.getSession().setAttribute("wantedGifts", e.getWantedGifts());
		response.sendRedirect("/eventInfoPage");
	}
	
	@RequestMapping(
			value = "/openOtherEvent/{id}",
			method = RequestMethod.GET
			)
	public void openOtherEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Event e = eventService.findOne(id);
		request.getSession().setAttribute("event", e);
		request.getSession().setAttribute("wantedGifts", e.getWantedGifts());
		response.sendRedirect("/otherEventInfoPage");
	}
	
	@RequestMapping(
			value = "/openOtherEvent2/{id}",
			method = RequestMethod.GET
			)
	public void openOtherEvent2(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Event e = eventService.findOne(id);
		request.getSession().setAttribute("event", e);
		request.getSession().setAttribute("wantedGifts", e.getWantedGifts());
		response.sendRedirect("/otherEventInfoPage2");
	}
	
	@RequestMapping(
			value = "/deleteEvent/{id}",
			method = RequestMethod.POST
			)
	public void deleteEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		eventService.delete(id);
		
		response.sendRedirect("/loggedUserPage");
	}
	
	@RequestMapping(
			value = "/UpdateEvent/{id}",
			method = RequestMethod.POST
			)
	public void updateEvent(@PathVariable("id") Long id,Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		String name =  request.getParameter("name");
		String description =  request.getParameter("description");
		String str = request.getParameter("date");
		Event event = eventService.findOne(id);
		event.setName(name);
		event.setDescription(description);
		if(!str.equals("")){
			DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
			Date date = formatter.parse(str);
			event.setDate(date);
		}
		
		Event updatedEvent = eventService.update(event);
		if(updatedEvent != null){
			request.getSession().setAttribute("updateEventMessage", "Event was updated successfully!");
		}
		else{
			request.getSession().setAttribute("updateEventMessage","Oops! Couldn't update an event!Please try again!" );
		}
		response.sendRedirect("/openUpdateEventPage/"+updatedEvent.getId());
	}
	
	@RequestMapping(
			value = "/openUpdateEventPage/{id}",
			method = RequestMethod.GET
			)
	public void openUpdateEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Event event = eventService.findOne(id);
		request.getSession().setAttribute("event", event);
		response.sendRedirect("/updateEvent");
	}
	
	@RequestMapping(
			value = "/EventSearch",
			method = RequestMethod.GET
			)
	public void userSearch(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String eventName = (String) request.getSession().getAttribute("searchedName");
		Collection<Event> events = eventService.findByNameContaining(eventName);
		User u = (User) request.getSession().getAttribute("user");
		Collection<Event> otherEvents = new ArrayList();
		for(Event e : events){
			if(e.getUser().getId()!=u.getId()){
				otherEvents.add(e);
			}
		}
		request.getSession().setAttribute("events", otherEvents);
		response.sendRedirect("/searchedEvents");
	}
}
