package com.product.Services;

import java.util.List;
import java.util.Optional;

import com.product.Entity.Product;

public interface IProductService {

	Integer addProduct(Product product);

	public List<Product> getAllProducts();
	
	Optional<Product> getProduct(Integer Id);
	
	Product updateProduct(Product product, Integer Id);
	
	public void deleteproduct(Integer Id);
	
}
