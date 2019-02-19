package com.niit.furniturebackend.DAO;


import java.util.List;

import com.niit.furniturebackend.model.Category;

public interface CategoryDAO
{
	boolean createCategory(Category category);
	   boolean updateCategory(Category category);
	   boolean deleteCategory(Category category);
	   List<Category> selectAllCategory();
	   Category selectOneCategory(int category_id);
	

}
