package org.springboot.web.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.model.User;
import org.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BaseController {

	@Autowired
	UserService userService;
	
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
	public ModelAndView eventInfoPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("eventInfoPage");
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
	
}
