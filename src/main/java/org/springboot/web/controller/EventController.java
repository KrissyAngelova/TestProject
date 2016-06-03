package org.springboot.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			request.getSession().setAttribute("message", "Event was created successfully!");
		}
		else{
			request.getSession().setAttribute("message","Oops! Couldn't make an event!Please try again!" );
		}
		response.sendRedirect("/createEvent");
	}
	
	@RequestMapping(
			value = "/openEvent/{id}",
			method = RequestMethod.GET
			)
	public void openEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Event e = eventService.findById(id);
		request.getSession().setAttribute("event", e);
		response.sendRedirect("/eventInfoPage");
	}
	
	@RequestMapping(
			value = "/deleteEvent/{id}",
			method = RequestMethod.POST
			)
	public void deleteEvent(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		eventService.delete(id);
		
		response.sendRedirect("/loggedUserPage");
	}
}
