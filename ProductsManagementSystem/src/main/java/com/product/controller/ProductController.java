package com.product.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Product;
import com.product.Services.IProductService;


@RestController
public class ProductController {
	// CRUD c-> create, R -> read, U -> update and D-> delete

	@Autowired
	IProductService productService;
	
	@PostMapping("/addproduct")
	Integer addproduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);
		System.out.println(id);
		return id;
	}
	@GetMapping("/allproducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	Optional<Product> getProduct(@PathVariable Integer id){
		Optional<Product> product =productService.getProduct(id);
		return product;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer Id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, Id), HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{Id}")
	public ResponseEntity<Product> deleteproduct(@PathVariable Integer Id){
		System.out.println(Id);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			productService.deleteproduct(Id);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			// TODO: handle exception
		}
		return responseEntity;
	}
	
//	@DeleteMapping("/delete")
//    public String deleteAllBYIds(@RequestParam("ids") List<Integer> ids) {
//        System.out.println("deleting");
//        productService.deleteAllBYIds(ids);
//        return String.join(",", ids.stream().map(value ->  Integer.toString(value)).collect(Collectors.toList()));
//    }
//	@DeleteMapping("/delete")
//	public void deleteAllBYIds(List<Integer> integers) {
//      productService.deleteByIdIn(new ArrayList<>(integers));
//	 productService.deleteAll();
//
//      System.out.println("deleted");
//  }
	
}
