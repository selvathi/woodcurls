package com.niit.furnitureforntend.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.furniturebackend.DAO.AddressDAO;
import com.niit.furniturebackend.DAO.CartDAO;
import com.niit.furniturebackend.DAO.OrderDAO;
import com.niit.furniturebackend.DAO.ProductDAO;
import com.niit.furniturebackend.DAO.UserDetailsDAO;
import com.niit.furniturebackend.model.Cart;
import com.niit.furniturebackend.model.Myorder;
import com.niit.furniturebackend.model.Product;


@Controller
@RequestMapping("/user")
public class OrderController {
	@Autowired
	CartDAO cartdao;

	@Autowired
	AddressDAO adddao;

	@Autowired
	UserDetailsDAO userdao;

	@Autowired
	ProductDAO prodao;

	@Autowired
	OrderDAO ordedao;

	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam("addressid") int addid, Model model, HttpSession httpSession) {
		Myorder oMyorder = new Myorder();
		ArrayList<Cart> carts = (ArrayList<Cart>) cartdao
				.selectAllCart(Integer.parseInt(httpSession.getAttribute("userid").toString()));
		Iterator<Cart> iterator = carts.iterator();
		while (iterator.hasNext()) {
			System.out.println("dfd");
			Date d = new Date();
			long id = UUID.randomUUID().getMostSignificantBits();
			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));
			Cart cart = (Cart) iterator.next();
			Product p = prodao.selectOneProduct(cart.getProduct().getProduct_id());
			System.out.println(p.getProduct_quantity());
			System.out.println(cart.getQuantity());
			if (p.getProduct_quantity() >= cart.getQuantity()) 
			{
				System.out.println("34");
				oMyorder.setAddress(adddao.selectOneAddress(addid));
				oMyorder.setOrder_id(oid);
				oMyorder.setOdate(d);
				oMyorder.setQuantity(cart.getItem_id());
				oMyorder.setProduct(cart.getProduct());
				oMyorder.setTotal(cart.getSub_Total());
				oMyorder.setUserdetails(userdao.selectOneUser(httpSession.getAttribute("useremail").toString()));
				int qty=p.getProduct_quantity() - cart.getQuantity();
				p.setProduct_quantity(qty);
				if (ordedao.createOrder(oMyorder))
				{
					prodao.updateProduct(p);
					cartdao.deleteCart(cart);
				}
			}
		}
		ArrayList<Cart> cartitems = (ArrayList<Cart>) cartdao.selectAllCart(Integer.parseInt(httpSession.getAttribute("userid").toString()));
		httpSession.setAttribute("itemcount", cartitems.size());
		model.addAttribute("orderlist", ordedao.selectAllOrder(Integer.parseInt(httpSession.getAttribute("userid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}
	
	@RequestMapping("/vieworders")
	String viewallorders(Model model,HttpSession httpSession)
	{
		model.addAttribute("orderlist", ordedao.selectAllOrder(Integer.parseInt(httpSession.getAttribute("userid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
		
	}
	

	@RequestMapping("/receipt")
	String receipt(@RequestParam("rid")String oid,Model model,HttpSession httpSession)
	
	{
		model.addAttribute("order", ordedao.selectOneOrder(oid));
		model.addAttribute("receiptpage", true);
		return "index";
		
	}

}
	

