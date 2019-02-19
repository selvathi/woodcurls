package com.niit.furniturebackend.DAOImpl;

import java.util.List;//import DAO.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.furniturebackend.DAO.CategoryDAO;
import com.niit.furniturebackend.model.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {


	@Autowired
	SessionFactory sessionFactory;
	public boolean createCategory(Category category) {
		
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public List<Category> selectAllCategory() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Category").list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

	@Override
	public Category selectOneCategory(int category_id) {
		// TODO Auto-generated method stub
		try {
			return (Category)sessionFactory.getCurrentSession().createQuery("from Category where category_id="+category_id).uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

}
