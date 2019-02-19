package com.niit.furniturebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 int category_id;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="its required")
	 String category_name;
	
	@Column(nullable=false,columnDefinition="text")
	@NotEmpty(message="its required")
	 String category_desc;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_desc() {
		return category_desc;
	}
	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}
	

}
