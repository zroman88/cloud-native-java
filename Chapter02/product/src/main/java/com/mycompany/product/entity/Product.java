package com.mycompany.product.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 1;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int catId;

	public Product() {
		
	}
	
	public Product(int id) {
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

	public int getId() {
		return id;
	}

}
