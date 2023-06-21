package com.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
//	Welcoming message
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Park & Pick users";
	}
	
	// get all users
	@GetMapping("/all")
	public List<Product> getAllProducts(){
    	System.out.println("All products are listed here");
		return this.productRepository.findAll();
    }
	// get user by id
	@GetMapping("/{id}")
	public Product getUseById(@PathVariable(value = "id") long product_id) {
		
		return this.productRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ product_id));
	
	}
	// create user 
	
	@PostMapping("/register")
	public Product createUser(@RequestBody Product product) {
		
		return this.productRepository.save(product);
	}
	
	// update user
	@PutMapping("/{id}")
	public Product updateUser(@RequestBody Product product, @PathVariable("id") long product_id) {
		Product existing = this.productRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ product_id));
		existing.setProduct_name(product.getProduct_name());
		existing.setCurrent_stock(product.getPrice());
		existing.setDescription(product.getDescription());
				
		this.productRepository.save(existing);
		return existing;
	}
	//delete user by id
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteUser(@PathVariable("id") long id){
		Product existing = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ id));
	    this.productRepository.delete(existing);
	    return ResponseEntity.ok().build();
	}
}
