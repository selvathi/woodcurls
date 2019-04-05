package com.niit.furnitureforntend.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.adapter.HttpWebHandlerAdapter;

import com.niit.furniturebackend.DAO.AddressDAO;
import com.niit.furniturebackend.model.Address;
import com.niit.furniturebackend.model.Product;

@Controller
@RequestMapping("/user")
public class AddressController 
{
	@Autowired
	AddressDAO addressdao;
	
	@RequestMapping("/address")
	String address(Model model,HttpSession session) {
		model.addAttribute("addresspage", true);
		model.addAttribute("myaddress", new Address());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
		model.addAttribute("edit", false);
		model.addAttribute("error3", false);
		return"index";
		
	}
	@RequestMapping("/createaddress")
	String insteraddress(@Valid @ModelAttribute("myaddress") Address address, BindingResult bindingResult, Model model,HttpSession session)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress", address);model.addAttribute("error1", false);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
			model.addAttribute("edit", false);
			model.addAttribute("error3", false);

		}

		else {
			try {
				if (addressdao.createAddress(address)) {
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else
				{
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("error1", false);
					model.addAttribute("success",false);
					model.addAttribute("error2", false);
					model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("edit", false);
					model.addAttribute("error3", true);
				}
			} catch (Exception e) {
				model.addAttribute("addresspage", true);
				model.addAttribute("myaddress", address);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
				model.addAttribute("edit", false);
				model.addAttribute("error3", false);
			}
		}
		return "index";
	}

@RequestMapping("/deleteaddress")
String deletepage(@RequestParam("address_id")int address_id,Model model,HttpSession session)
	{
	try
	{
		if(addressdao.deleteAddress(addressdao.selectOneAddress(address_id)))
		return "redirect:/user/address";
		else
		{
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress",new Address());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
		    model.addAttribute("error2", false);
		    model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
		    model.addAttribute("edit",false);
		    model.addAttribute("error3", true);
			return "index";
			
		}
	}
	catch(Exception e)
	{
		model.addAttribute("addresspage", true);
		model.addAttribute("myaddress",new Address());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
	    model.addAttribute("error2", false);
	    model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
	    model.addAttribute("edit",false);
	    model.addAttribute("error3", true);
		return "index";
	}
	}
	@RequestMapping("/editaddress")
	String editpage(@RequestParam("address_id")int address_id,Model model,HttpSession session)
	{
	model.addAttribute("addresspage", true);
	model.addAttribute("myaddress",addressdao.selectOneAddress(address_id));
	model.addAttribute("error1", false);
	model.addAttribute("success", false);
    model.addAttribute("error2", false);
    model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
    model.addAttribute("edit",true);
    model.addAttribute("error3",false);
	return "index";
	}
	@RequestMapping("/updateaddress")
	String editpage(@Valid @ModelAttribute("myaddress")Address address,BindingResult bindingResult,Model model,HttpSession session)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress",address);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
			model.addAttribute("edit",true);
			model.addAttribute("error3", false);
		}

		else 
		{
			try 
			{
				if (addressdao.updateAddress(address))
			{
					
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else{
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
					model.addAttribute("edit", true);
					model.addAttribute("error3", true);
				}
			} 
			catch (Exception e) {
				
				model.addAttribute("addresspage", true);
				model.addAttribute("myaddress",address);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("Address_list", addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("userid").toString())));
				model.addAttribute("edit", true);
				model.addAttribute("error3", false);
			}
		}
		return "index";
	}
	
	
}




	
	
