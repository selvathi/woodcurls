package com.niit.furniturebackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.CartDAO;
import com.niit.furniturebackend.model.Cart;


@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean createCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}
	@Override
	public List<Cart> selectAllCart(int u_id) {
		List<Cart> cartlist=new ArrayList<Cart>();
		try {
			cartlist=sessionFactory.getCurrentSession().createQuery("from Cart where userdetails_u_id="+u_id).list();
			return cartlist;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return cartlist;
	}
	}
	
	@Override
	public Cart selectOneCart(int item_id)
	{
		try {
			return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where item_id="+item_id).uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
		
	}

}
