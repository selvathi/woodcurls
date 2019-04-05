package com.niit.furniturebackend.DAO;



import com.niit.furniturebackend.model.UserDetails;

public interface UserDetailsDAO 
{
   boolean createUserDetails(UserDetails userdetails);
   boolean updateUserDetails(UserDetails userdetails);
   boolean deteleUserDetails(UserDetails userdetails);
   
   UserDetails selectOneUser(String emailid);
   
}

