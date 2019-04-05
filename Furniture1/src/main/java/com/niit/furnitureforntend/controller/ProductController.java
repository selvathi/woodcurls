package com.niit.furnitureforntend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.furniturebackend.DAO.CategoryDAO;
import com.niit.furniturebackend.DAO.ProductDAO;
import com.niit.furniturebackend.model.Product;

@Controller
@RequestMapping("/supplier")
public class ProductController {

	@Autowired
	ProductDAO productdao;
	
	@Autowired
	CategoryDAO cat;
	
	void addimage(MultipartFile f, int id) {
		try {
			String path = "E:\\projectphase\\Furniture1\\src\\main\\webapp\\resources\\pimages\\";
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}	}	

	@RequestMapping("/product")
	String productpage(Model model) {
		model.addAttribute("productpage", true);
		model.addAttribute("myproduct", new Product());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("Product_list", productdao.selectAllProduct());
		model.addAttribute("Category_list", cat.selectAllCategory());
		model.addAttribute("edit", false);
		model.addAttribute("error3", false);
		return "index";
	}

	@RequestMapping("/createproduct")
	String instercategory(@Valid @ModelAttribute("myproduct") Product product, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("productpage", true);
			model.addAttribute("myproduct", product);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Product_list", productdao.selectAllProduct());
			model.addAttribute("Category_list", cat.selectAllCategory());
			model.addAttribute("edit", false);
			model.addAttribute("error3", false);
		}

		else {
			try {
				if (productdao.createProduct(product)) {
					addimage(product.getPimage(), product.getProduct_id());
					model.addAttribute("productpage", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Product_list", productdao.selectAllProduct());
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else
				{
					model.addAttribute("productpage", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success",false);
					model.addAttribute("error2", false);
					model.addAttribute("Product_list", productdao.selectAllProduct());
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", false);
					model.addAttribute("error3", true);
					
				}
			} catch (Exception e) {
				model.addAttribute("productpage", true);
				model.addAttribute("myproduct", product);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("Product_list", productdao.selectAllProduct());
				model.addAttribute("Category_list", cat.selectAllCategory());
				model.addAttribute("edit", false);
				model.addAttribute("error3", false);
			}
		}
		return "index";
	}

@RequestMapping("/deleteproduct")
String deletepage(@RequestParam("product_id")int product_id,Model model )
	{
	try
	{
		if(productdao.deleteProduct(productdao.selectOneProduct(product_id)))
		return "redirect:/product";
		else
		{
			model.addAttribute("productpage", true);
			model.addAttribute("myproduct",new Product());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
		    model.addAttribute("error2", false);
		    model.addAttribute("Product_list", productdao.selectAllProduct());
		    model.addAttribute("Category_list", cat.selectAllCategory());
		    model.addAttribute("edit",false);
		    model.addAttribute("error3", true);
			return "index";
			
		}
	}
	catch(Exception e)
	{
		model.addAttribute("productpage", true);
		model.addAttribute("myproduct",new Product());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
	    model.addAttribute("error2", false);
	    model.addAttribute("Product_list", productdao.selectAllProduct());
	    model.addAttribute("Category_list", cat.selectAllCategory());
	    model.addAttribute("edit",false);
	    model.addAttribute("error3", true);
		return "index";
	}
	}
	@RequestMapping("/editproduct")
	String editpage(@RequestParam("product_id")int product_id,Model model)
	{
	model.addAttribute("productpage", true);
	model.addAttribute("myproduct",productdao.selectOneProduct(product_id));
	model.addAttribute("error1", false);
	model.addAttribute("success", false);
    model.addAttribute("error2", false);
    model.addAttribute("Product_list", productdao.selectAllProduct());
    model.addAttribute("Category_list", cat.selectAllCategory());
    model.addAttribute("edit",true);
    model.addAttribute("error3",false);
	return "index";
	}
	@RequestMapping("/updateproduct")
	String editpage(@Valid @ModelAttribute("myproduct")Product product,BindingResult bindingResult,Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("productpage", true);
			model.addAttribute("myproduct",product);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("Product_list", productdao.selectAllProduct());
			model.addAttribute("Category_list", cat.selectAllCategory());
			model.addAttribute("edit",true);
			model.addAttribute("error3", false);
		}

		else 
		{
			try 
			{
				if (productdao.updateProduct(product))
				{
					addimage(product.getPimage(), product.getProduct_id());
					model.addAttribute("productpage", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Product_list", productdao.selectAllProduct());
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", false);
					model.addAttribute("error3", false);
				}
				else{
					model.addAttribute("productpage", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("Product_list", productdao.selectAllProduct());
					model.addAttribute("Category_list", cat.selectAllCategory());
					model.addAttribute("edit", true);
					model.addAttribute("error3", true);
				}
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
				model.addAttribute("productpage", true);
				model.addAttribute("myproduct",product);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("Product_list", productdao.selectAllProduct());
				model.addAttribute("Category_list", cat.selectAllCategory());
				model.addAttribute("edit", true);
				model.addAttribute("error3", false);
			}
		}
		return "index";
	}
	
	
}



