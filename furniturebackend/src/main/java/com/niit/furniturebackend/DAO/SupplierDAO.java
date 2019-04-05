package com.niit.furniturebackend.DAO;

import java.util.List;

import com.niit.furniturebackend.model.Supplier;



public interface SupplierDAO
{
	boolean createSupplier(Supplier supplier);
	   boolean updateSupplier(Supplier supplier);
	   boolean deleteSupplier(Supplier supplier);
	   List<Supplier> selectAllSupplier();
	   Supplier selectOneSupplier(String email_id);
	    
	
}
