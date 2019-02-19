package com.niit.furniturebackend.DAO;

import java.util.List;

import com.niit.furniturebackend.model.UserDetails;

public interface UserDetailsDAO 
{
   boolean createUserDetails(UserDetails userdetails);
   boolean updateUserDetails(UserDetails userdetails);
   boolean deteleUserDetails(UserDetails userdetails);
   List<UserDetails> selectAllUser();
   UserDetails selectOneUser(int user_id);
   
}

