package com.product.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repo.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Integer addProduct(Product product) {
		Product addProduct = productRepository.save(product);
		return addProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer Id) {
		
		return productRepository.findById(Id);
	}
	
	@Override
	public Product updateProduct(Product product, Integer Id) {
		Product existingProduct =productRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("Product", "id", Id));
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductCategory(product.getProductCategory());
		existingProduct.setProductPrice(product.getProductPrice());
		// we will update the values and then save the new updated data
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteproduct(Integer Id) {
		productRepository.deleteById(Id);
		
	}
//	@Override
//	public void deleteAllBYIds(List<Integer> integers) {
//		
//		productRepository.deleteAll();
//	}

//	@Override
//	public void deleteAllProducts() {
//		
//		productRepository.deleteAll();
//	}
	
}
