package com.niit.furniturebackend.DAOImpl;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.AddressDAO;
import com.niit.furniturebackend.model.Address;



@Repository("AddressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean createAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}
	@Override
	public List<Address>selectAllAddress(int u_id) {

		try {
			return sessionFactory.getCurrentSession().createQuery("from Address where userdetails_u_id="+u_id).list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}
	
	@Override
	public Address selectOneAddress(int address_id) {
		try {
			return (Address)sessionFactory.getCurrentSession().createQuery("from Address where address_id='"+address_id+"'").uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
			}

	}
}
