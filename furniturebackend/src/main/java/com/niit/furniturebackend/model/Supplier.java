package com.niit.furniturebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 int supplier_id;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="its required")
	 String supplier_name;
	
	@Column(nullable=false)
	@NotEmpty(message="its required")
     String location;
	
	@Column(nullable = false, unique = true)
	@NotEmpty(message="its required")
	   String supplier_emailid;
	
	 @Column(nullable=false)
	    @Transient
	    @NotEmpty(message="its required")
	     String password;
	
	 @Column(nullable= false, unique=true)
	 @NotEmpty(message="its required")
     String phoneno;
	 
	 

	 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupplier_emailid() {
		return supplier_emailid;
	}

	public void setSupplier_emailid(String supplier_emailid) {
		this.supplier_emailid = supplier_emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	 
	
	
	
    


}