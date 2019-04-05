package com.niit.furniturebackend.DAOImpl;



import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.UserDetailsDAO;
import com.niit.furniturebackend.model.UserCred;
import com.niit.furniturebackend.model.UserDetails;


@Repository("UserDetailsDAO")
@Transactional
public  class UserDetailsDAOImpl implements UserDetailsDAO
{

	@Autowired
	SessionFactory sessionFactory;
	public boolean createUserDetails(UserDetails userdetails) 
	{
		try
		{
			UserCred usercred=new UserCred();
			usercred.setEmailid(userdetails.getEmailid());
			usercred.setUser_Password(userdetails.getPassword());
			usercred.setStatus("true");
			usercred.setRole("ROLE_USER");
			sessionFactory.getCurrentSession().save(usercred);
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean updateUserDetails(UserDetails userdetails) 
	{
		try {
			sessionFactory.getCurrentSession().update(userdetails);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deteleUserDetails(UserDetails userdetails) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(userdetails);
			sessionFactory.getCurrentSession().delete(userdetails.getEmailid(),UserCred.class);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	
	public UserDetails selectOneUser(String emailid) 
	{
		try 
		{
			return (UserDetails)sessionFactory.getCurrentSession().createQuery("from UserDetails where emailid='"+emailid+"'").uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
	}
	
	}

	
}
