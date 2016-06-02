package org.springboot.web.controller;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

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
	
	
}
