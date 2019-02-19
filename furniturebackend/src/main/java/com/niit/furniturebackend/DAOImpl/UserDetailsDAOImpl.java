package com.niit.furniturebackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.UserDetailsDAO;
import com.niit.furniturebackend.model.UserCred;
import com.niit.furniturebackend.model.UserDetails;


@Repository
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
			usercred.setRole("Role_user");
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

	@Override
	public List<UserDetails> selectAllUser() 
	{
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
	}
	}

	public UserDetails selectOneUser(int user_id) 
	{
		try 
		{
			return (UserDetails)sessionFactory.getCurrentSession().createQuery("from UserDetails where u_id="+user_id).uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
	}
	
	}

	
}
