package com.niit.furniturebackend.DAOImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.OrderDAO;

import com.niit.furniturebackend.model.Myorder;


@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean createOrder(Myorder order) {
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}

	@Override
	public boolean updateOrder(Myorder order) {
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deleteOrder(Myorder order) {
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public List<Myorder> selectAllOrder(int u_id) {

		try {
			return sessionFactory.getCurrentSession().createQuery("from Myorder where userdetails ="+u_id).list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

	@Override
	public Myorder selectOneOrder(String order_id) {
		try {
			return (Myorder)sessionFactory.getCurrentSession().createQuery("from Myorder where order_id='"+order_id+"'").uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

}
