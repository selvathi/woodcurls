package com.niit.furnitureforntend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.furniturebackend.DAO.UserDetailsDAO;

import com.niit.furniturebackend.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	UserDetailsDAO userdetailsdao;
	@RequestMapping("/register")
	String registerpage(Model model) {
		model.addAttribute("register", true);
		model.addAttribute("myuserdetails", new UserDetails());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		return "index";
	}

	@RequestMapping("/createregister")
	String insterregisterpage(@Valid @ModelAttribute("myuserdetails") UserDetails userdetails, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("register", true);
			model.addAttribute("myuserdetails",userdetails);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			
		}

		else {
			try {
				if (userdetailsdao.createUserDetails(userdetails))
				{
					model.addAttribute("register", true);
					model.addAttribute("myuserdetails",new UserDetails());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					
				}
				else
				{
					model.addAttribute("register", true);
					model.addAttribute("myuserdetails", new UserDetails());
					model.addAttribute("error1", true);
					model.addAttribute("success",false);
					model.addAttribute("error2", true);
					
					
				}
			} catch (Exception e) {
				model.addAttribute("register", true);
				model.addAttribute("myuserdetilsdao",new UserDetails());
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
			}
		}
		return "index";
	}


}
