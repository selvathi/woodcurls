package com.niit.furnitureforntend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.furniturebackend.DAO.CategoryDAO;
import com.niit.furniturebackend.model.Category;


@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	CategoryDAO cat;

	@RequestMapping("/category")
	String productpage(Model model) {
		model.addAttribute("catpage", true);
		model.addAttribute("mycategory", new Category());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("Category_list", cat.selectAllCategory());
		model.addAttribute("edit", false);
		model.addAttribute("error3", false);
		return "index";
	}
	
	@RequestMapping("/createCategory")
	String instercategory(@Valid @ModelAttribute("mycategory") Category category, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) 
		{
		model.addAttribute("catpage", true);
		model.addAttribute("mycategory", category);
		model.addAttribute("error1", true);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("Category_list", cat.selectAllCategory());
		model.addAttribute("edit", false);
		model.addAttribute("error3", false);
	}

	else {
		try {
			if (cat.createCategory(category))
			{
				
				model.addAttribute("catpage", true);
				model.addAttribute("mycategory", new Category());
				model.addAttribute("error1", false);
				model.addAttribute("success", true);
				model.addAttribute("error2", false);
				model.addAttribute("Category_list", cat.selectAllCategory());
				model.addAttribute("edit", false);
				model.addAttribute("error3", false);
			}
			else
			{
				model.addAttribute("catpage", true);
				model.addAttribute("mycategory", new Category());
				model.addAttribute("error1", false);
				model.addAttribute("success",false);
				model.addAttribute("error2", false);
				model.addAttribute("Category_list", cat.selectAllCategory());
				model.addAttribute("edit", false);
				model.addAttribute("error3", true);
				
			}
		} catch (Exception e) {
			model.addAttribute("catpage", true);
			model.addAttribute("mycategory", category);
			model.addAttribute("error1", false);
			model.addAttribute("error2", true);
			model.addAttribute("success", false);
			model.addAttribute("Category_list", cat.selectAllCategory());
			model.addAttribute("edit", false);
			model.addAttribute("error3", false);
		}
	}
	return "index";
}


@RequestMapping("/deletecategory")
String deletepage(@RequestParam("c_id")int category_id,Model model )
	{
	try
	{
		if(cat.deleteCategory(cat.selectOneCategory(category_id)))
		return "redirect:/category";
		else
		{
			model.addAttribute("catpage", true);
			model.addAttribute("mycategory",new Category());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
		    model.addAttribute("error2", false);
		    model.addAttribute("Category_list", cat.selectAllCategory());
		    model.addAttribute("edit",false);
		    model.addAttribute("error3", true);
			return "index";
		}
	}
	catch(Exception e)
	{
		model.addAttribute("catpage", true);
		model.addAttribute("mycategory",new Category());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
	    model.addAttribute("error2", false);
	    model.addAttribute("Category_list", cat.selectAllCategory());
	    model.addAttribute("edit",false);
	    model.addAttribute("error3", true);
		return "index";
	}
	}
	@RequestMapping("/editcategory")
	String editpage(@RequestParam("c_id")int category_id,Model model)
	{
	model.addAttribute("catpage", true);
	model.addAttribute("mycategory",cat.selectOneCategory(category_id));
	model.addAttribute("error1", false);
	model.addAttribute("success", false);
    model.addAttribute("error2", false);
    model.addAttribute("Category_list", cat.selectAllCategory());
    model.addAttribute("edit",true);
    model.addAttribute("error3",false);
	return "index";
	}
	@RequestMapping("/updatecategory")
	String updatepage(@Valid @ModelAttribute("mycategory")Category category,BindingResult bindingResult,Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("catpage", true);
			model.addAttribute("mycategory",category);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Category_list", cat.selectAllCategory());
			model.addAttribute("edit",true);
			model.addAttribute("error3", false);
		}

		else {
			try {
				if (cat.updateCategory(category))
				{
					
					model.addAttribute("catpage", true);
					model.addAttribute("mycategory", new Category());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else{
					model.addAttribute("catpage", true);
					model.addAttribute("mycategory", new Category());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", true);
					model.addAttribute("error3", true);
				}
			} 
			catch (Exception e) {
			
				model.addAttribute("catpage", true);
				model.addAttribute("mycategory",category);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("Category_list", cat.selectAllCategory());
				model.addAttribute("edit", true);
				model.addAttribute("error3", false);
			}
		}
		return "index";

	}
}

