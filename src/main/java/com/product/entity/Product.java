package com.product.entity;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	private long product_id;
	@Column
	private String product_name;
	@Column
	private String description;
	@Column
	private long price;
		
	public Product() {
	
	}
	public Product(Long product_id, String product_name, String decription, long price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String decription) {
		this.description = decription;
	}
	public long getPrice() {
		return price;
	}
	public void setCurrent_stock(long price) {
		this.price = price;
	}
	
}
