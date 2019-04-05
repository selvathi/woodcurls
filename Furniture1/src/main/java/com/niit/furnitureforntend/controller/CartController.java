package com.niit.furnitureforntend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.furniturebackend.DAO.CartDAO;
import com.niit.furniturebackend.DAO.ProductDAO;
import com.niit.furniturebackend.DAO.UserDetailsDAO;
import com.niit.furniturebackend.model.Cart;
import com.niit.furniturebackend.model.Product;

@Controller
public class CartController {
	@Autowired
	CartDAO cartdao;
	@Autowired
	UserDetailsDAO userdao;
	@Autowired
	ProductDAO productdao;

	@RequestMapping("/user/viewcart")
	String viewCart(Model model, HttpSession session) 
	{
		List<Cart> cartitems=	cartdao.selectAllCart(Integer.parseInt(session.getAttribute("userid").toString()));
		model.addAttribute("cartpage", true);
		model.addAttribute("cartitems",cartitems);
		session.setAttribute("itemcount", cartitems.size());
		return "index";
	}

	@RequestMapping("/addToCart")
	String addToCart(HttpSession httpSession,@RequestParam("pid")int pid) {
		if (httpSession.getAttribute("userid") == null) 
		{
			httpSession.setAttribute("pid",pid);
			return "redirect:/login";
		} 
		else 
		{
		ArrayList<Cart> cartlist=(ArrayList<Cart>)cartdao.selectAllCart(Integer.parseInt(httpSession.getAttribute("userid").toString()));
		if(cartlist.isEmpty()){
		Cart c=new Cart();
			Product p=productdao.selectOneProduct(pid);
			c.setUserdetails(userdao.selectOneUser(httpSession.getAttribute("useremail").toString()));
			c.setProduct(p);
			c.setQuantity(1);
			c.setSub_Total(p.getProduct_price());
			cartdao.createCart(c);
		}
		else{
			Iterator<Cart> iterator=cartlist.listIterator();
			while(iterator.hasNext()){
				Cart cart=(Cart)iterator.next();
				Product p= cart.getProduct();
				if (p.getProduct_id()==pid){
					int qty= cart.getQuantity();
					qty=qty+1;
					cart.setQuantity(qty);
					cart.setSub_Total(qty*p.getProduct_price());
					cartdao.updateCart(cart);
					return"redirect:/user/viewcart";
				}
			}
			Cart c=new Cart();
			Product p=productdao.selectOneProduct(pid);
			c.setUserdetails(userdao.selectOneUser(httpSession.getAttribute("useremail").toString()));
			c.setProduct(p);
			c.setQuantity(1);
			c.setSub_Total(p.getProduct_price());
			cartdao.createCart(c);
		}
			return"redirect:/user/viewcart";

		}
	}
	@RequestMapping("/user/deleteitem")
	String deleteItem(@RequestParam("catid")int id)
	{
		cartdao.deleteCart(cartdao.selectOneCart(id));
		return"redirect:/user/viewcart";

	}
}
