package com.sip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/home")
	//@ResponseBody
	public String home() {
		
		
       return"front/index.html";}
    @RequestMapping("/login")
    @ResponseBody
	public String login() {
		return"login.html";}
	@RequestMapping("/registration")
	@ResponseBody
	public String registration() {
		return"registration.html";}
	public String forgotpassword() {
		return"";}
	
     @RequestMapping("/contact")
	public String contact() {
		
		return "front/contact.html";}

}



