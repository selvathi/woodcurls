package com.niit.furniturebackend.DAOImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.SupplierDAO;
import com.niit.furniturebackend.model.Supplier;
import com.niit.furniturebackend.model.UserCred;


@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	public boolean createSupplier(Supplier supplier) {
		try {
			UserCred usercred=new UserCred();
			usercred.setEmailid(supplier.getSupplier_emailid());
			usercred.setUser_Password(supplier.getPassword());
			usercred.setStatus("true");
			usercred.setRole("ROLE_ADMIN");
			sessionFactory.getCurrentSession().save(usercred);
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	
	}

	
	public boolean updateSupplier(Supplier supplier) 
	{
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}

	@Override
	public boolean deleteSupplier(Supplier supplier)
	{
		try {
			sessionFactory.getCurrentSession().delete(supplier.getSupplier_emailid(),UserCred.class);
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public List<Supplier> selectAllSupplier() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

	@Override
	public Supplier selectOneSupplier(String email_id)
	{
		try {
			return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where supplier_emailid='"+email_id+"'").uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

}
