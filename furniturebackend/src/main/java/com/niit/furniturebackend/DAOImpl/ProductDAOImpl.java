package com.niit.furniturebackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.furniturebackend.DAO.ProductDAO;
import com.niit.furniturebackend.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public List<Product> selectAllProduct() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

	@Override
	public Product selectOneProduct(int product_id) {
		// TODO Auto-generated method stub
		try {
			return (Product)sessionFactory.getCurrentSession().createQuery("from Product where product_id="+product_id).uniqueResult();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
	}
	}

}
