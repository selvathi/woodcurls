package com.niit.furniturebackend.DAO;

import java.util.List;

import com.niit.furniturebackend.model.Address;
import com.niit.furniturebackend.model.UserDetails;

public interface AddressDAO 
{
	boolean createAddress(Address address);
	   boolean updateAddress(Address address);
	   boolean deleteAddress(Address address);
	   List<Address> selectAllAddress(int u_id);
	   Address selectOneAddress(int address_id);
}
