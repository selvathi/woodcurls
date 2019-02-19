package com.niit.furnitureforntend.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController
{
	@RequestMapping("/")
	String homepage(Model model)
	{
		model.addAttribute("slider", true);
		return "index";
	}
	
	@RequestMapping("/aboutus")
	 String aboutus(Model model)
	{
		model.addAttribute("aboutus", true);
		return "index";
	}
	
	@RequestMapping("/contactus")
	String contactus(Model model)
	{
		model.addAttribute("contactus", true);
		return "index";
	}
	
//@RequestMapping("/register")
//String register(Model model)
	//{
		//model.addAttribute("register", true);
		//return "index";
	//}
	
	@RequestMapping("/login")
	String login(Model model)
	{
		model.addAttribute("login", true);
		return "index";
	}
}
