package com.wallmart.prova.repo;

import java.util.List;

import com.wallmart.prova.domain.Product;

public interface ProductDao {
	public List<Product> getAll();
	
	public Product getById(String id);
	
	public Product add(Product product);
	
	public Product alt(Product product);
	
	public void del(Product product);
	
}
