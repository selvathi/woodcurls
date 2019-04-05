package com.niit.furniturebackend.DAO;

import java.util.List;

import com.niit.furniturebackend.model.Cart;


public interface CartDAO {
	boolean createCart(Cart cart);
	   boolean updateCart(Cart cart);
	   boolean deleteCart(Cart cart);
	  List<Cart> selectAllCart(int u_id);
	  Cart selectOneCart(int item_id);
}
