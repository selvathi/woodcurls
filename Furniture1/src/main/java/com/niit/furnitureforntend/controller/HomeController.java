package com.niit.furnitureforntend.controller;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.furniturebackend.DAO.CartDAO;
import com.niit.furniturebackend.DAO.ProductDAO;
import com.niit.furniturebackend.DAO.SupplierDAO;
import com.niit.furniturebackend.DAO.UserDetailsDAO;
import com.niit.furniturebackend.model.Cart;
import com.niit.furniturebackend.model.Product;
import com.niit.furniturebackend.model.Supplier;
import com.niit.furniturebackend.model.UserDetails;


@Controller
public class HomeController
{
	@Autowired
	UserDetailsDAO userdetailsdao;
	@Autowired
	ProductDAO productdao;
	@Autowired
	CartDAO cartdao;

 @Autowired
 SupplierDAO supplierdao;
 
	@RequestMapping(value={"/","/home"})
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
		model.addAttribute("login",true);
		model.addAttribute("error",false);
		return "index";
	}
	@RequestMapping("/flogin")
	String flogin(Model model)
	{
		model.addAttribute("login", true);
		model.addAttribute("error",true);
		return "index";
	}
	@RequestMapping("/loginsuccess")

	public String isLoggedin(HttpSession session) 
	{
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			System.out.println(authority.getAuthority().toString());
			
			if (authority.getAuthority().equals("ROLE_USER")) 
			{
				UserDetails customer = userdetailsdao.selectOneUser(email);
				List<Cart> cartitems=cartdao.selectAllCart(customer.getU_id());
				session.setAttribute("useremail", customer.getEmailid());
				session.setAttribute("userid", customer.getU_id());
				session.setAttribute("userlogin", true);
				session.setAttribute("loginname",customer.getUsername());
				session.setAttribute("cartitems", cartitems);
				session.setAttribute("itemcount", cartitems.size());
				session.setAttribute("userlogin", true);
				if(session.getAttribute("pid")==null)
				{
					return"redirect:/allproductpage";
				}
				else
				{
					return"redirect:/addToCart?pid="+Integer.parseInt(session.getAttribute("pid").toString());

				}
				
			} 
			else if(authority.getAuthority().equals("ROLE_ADMIN")) 
			{
				Supplier supplier=supplierdao.selectOneSupplier(email);
				session.setAttribute("supplierlogin", true);
				session.setAttribute("supplierid",supplier.getSupplier_id());
				session.setAttribute("loginname",supplier.getSupplier_name());
			}
			else{
				session.setAttribute("Adminlogin", true);
				session.setAttribute("loginname", "Administrator");
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping( "/allproductpage")
	public String allproducts(Model m) 
	{
		m.addAttribute("allproductpage", true);
		m.addAttribute("myproduct",new Product());
		m.addAttribute("Product_list",productdao.selectAllProduct());
		return "index";
	}
	
	@RequestMapping( "/viewoneproduct")
	public String oneproductpage(Model m, @RequestParam("product_id") int product_id)
	{
		m.addAttribute("viewoneproduct", true);
		m.addAttribute("myproduct", productdao.selectOneProduct(product_id));
		return "index";

	}
	

}
