package com.niit.furnitureforntend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.furniturebackend.DAO.SupplierDAO;

import com.niit.furniturebackend.model.Supplier;


@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierdao;
	
	@RequestMapping("/supplier")
	String supplierpage(Model model) {
		model.addAttribute("supplierpage", true);
		model.addAttribute("mysupplier", new Supplier());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
        model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
		model.addAttribute("edit", false);
		model.addAttribute("error3", false);
		return "index";
	}
	
	@RequestMapping("/createsupplier")
	String instercategory(@Valid @ModelAttribute("mysupplier") Supplier supplier, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("supplierpage", true);
			model.addAttribute("mysupplier", supplier);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
	        model.addAttribute("edit", false);
			model.addAttribute("error3", false);
		}

		else {
			try {
				if (supplierdao.createSupplier(supplier))
				{	
					model.addAttribute("supplierpage", true);
					model.addAttribute("mysupplier", new Supplier());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else
				{
					model.addAttribute("supplierpage", true);
					model.addAttribute("mysupplier", new Supplier());
					model.addAttribute("error1", false);
					model.addAttribute("success",false);
					model.addAttribute("error2", false);
					model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
					model.addAttribute("edit", false);
					model.addAttribute("error3", true);
					
				}
			} catch (Exception e) {
				model.addAttribute("supplierpage", true);
				model.addAttribute("mysupplier", new Supplier());
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
				model.addAttribute("edit", false);
				model.addAttribute("error3", false);
			}
		}
		return "index";
	}
	
	@RequestMapping("/deletesupplier")
	String deletepage(@RequestParam("supplier_id")int supplier_id,Model model )
		{
		try
		{
			if(supplierdao.deleteSupplier(supplierdao.selectOneSupplier(supplier_id)))
			return "redirect:/supplier";
			else
			{
				model.addAttribute("supplierpage", true);
				model.addAttribute("mysupplier",new Supplier());
				model.addAttribute("error1", false);
				model.addAttribute("success", false);
			    model.addAttribute("error2", false);
			    model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
			    model.addAttribute("edit",false);
			    model.addAttribute("error3", true);
				return "index";
				
			}
		}
		catch(Exception e)
		{
			model.addAttribute("supplierpage", true);
			model.addAttribute("mysupplier",new Supplier());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
		    model.addAttribute("error2", false);
		    model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
		    model.addAttribute("edit",false);
		    model.addAttribute("error3", true);
			return "index";
		}
		}
	
		@RequestMapping("/editsupplier")
		String editpage(@RequestParam("supplier_id")int supplier_id,Model model)
		{
		model.addAttribute("supplierpage", true);
		model.addAttribute("mysupplier",supplierdao.selectOneSupplier(supplier_id));
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
	    model.addAttribute("error2", false);
	    model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
	    model.addAttribute("edit",true);
	    model.addAttribute("error3",false);
		return "index";
		}
		
		@RequestMapping("/updatesupplier")
		String editpage(@Valid @ModelAttribute("mysupplier")Supplier supplier,BindingResult bindingResult,Model model)
		{
			if (bindingResult.hasErrors())
			{
				model.addAttribute("supplierpage", true);
				model.addAttribute("mysuppliert",supplier);
				model.addAttribute("error1", true);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
				model.addAttribute("edit",true);
				model.addAttribute("error3", false);
			}

			else {
				try {
					if (supplierdao.updateSupplier(supplier))
					{
						
						model.addAttribute("supplierpage", true);
						model.addAttribute("mysupplier", new Supplier());
						model.addAttribute("error1", false);
						model.addAttribute("success", true);
						model.addAttribute("error2", false);
						model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
						model.addAttribute("edit", false);
						model.addAttribute("error3", false);
					}
					else{
						model.addAttribute("supplierpage", true);
						model.addAttribute("mysupplier", new Supplier());
						model.addAttribute("error1", false);
						model.addAttribute("success", true);
						model.addAttribute("error2", false);
						model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
						model.addAttribute("edit", true);
						model.addAttribute("error3", true);
					}
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
					model.addAttribute("supplierpage", true);
					model.addAttribute("mysupplier",supplier);
					model.addAttribute("error1", false);
					model.addAttribute("error2", true);
					model.addAttribute("success", false);
					model.addAttribute("Supplier_list", supplierdao.selectAllSupplier());
					model.addAttribute("edit", true);
					model.addAttribute("error3", false);
				}
			}
			return "index";
		}

}
