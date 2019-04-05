package com.niit.furniturebackend.DAO;

import java.util.List;

import com.niit.furniturebackend.model.Myorder;


public interface OrderDAO {
	boolean createOrder(Myorder myorder);
	   boolean updateOrder(Myorder myorder);
	   boolean deleteOrder(Myorder myorder);
	   List<Myorder> selectAllOrder(int u_id);
	   Myorder selectOneOrder(String  order_id);
}
