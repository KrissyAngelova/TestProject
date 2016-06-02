package org.springboot.web.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.model.User;
import org.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
            value = "/controller/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getUsers() {
        logger.info("> getUsers");

        Collection<User> greetings = userService.findAll();

        logger.info("< getUsers");
        return new ResponseEntity<Collection<User>>(greetings,HttpStatus.OK);
    }
	
	@RequestMapping(
            value = "/Login",
            method = RequestMethod.POST
            )
	public String Login(ModelMap model, HttpServletRequest request){
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		boolean exists = false;
		exists = userService.isUserExists(username, password);
		
		if(exists)
			return "success";
		else
			return "kofti";
			
	}
	
	@RequestMapping(
			value = "/Registration",
			method = RequestMethod.POST
			)
	public void Registration(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		boolean exists = userService.isUserExists(username, password);
		
		
		if(exists){
			request.getSession().setAttribute("message", "User already exists");
			
		}
		else{
			if(!userService.isUsernameTaken(username)){
				User u = new User(username, password);
				userService.create(u);
				request.getSession().setAttribute("message", "Registration created successfully");
				
			}
			else{
				request.getSession().setAttribute("message", "Username is taken");
				
			}
			
		}
		response.sendRedirect("/reg");
	}
	
	
}
