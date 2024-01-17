package com.study.servlet_study.service;


import com.study.servlet_study.entitiy.Product;
import com.study.servlet_study.repacitory.ProductRepository;

public class ProductService {
	
	private static ProductService instance;
	private ProductRepository productRepository;
	
	private ProductService() {
		productRepository = ProductRepository.getInstance();
	}
	
	public static ProductService getInstance() {
		if(instance == null) {
			instance = new ProductService();
		}
		return instance;
	}
	
	public int addProduct(Product product) {
		return productRepository.saveProduct(product);
	}
	
	public Product getProduct(String productName) {
		return productRepository.findProductByProductName(productName);
	}
}
