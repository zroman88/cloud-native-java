package com.mycompany.product.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document
public class Product implements Serializable {

	@Id
	private String id;

	private String name;

	private int catId;

	public Product() {
		
	}
	
	public Product(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getId() {
		return id;
	}

}
