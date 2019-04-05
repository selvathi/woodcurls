package com.niit.furniturebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 int u_id;
	
	@Column(nullable=false, unique=true)
     String username;

   @Column(nullable = false, unique = true)
       String emailid;

    @Column(nullable= false, unique=true)
     String phoneno;

    @Column(nullable=false)
    @Transient
     String password;

public int getU_id()
{
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getPhoneno() {
	return phoneno;
}

public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
