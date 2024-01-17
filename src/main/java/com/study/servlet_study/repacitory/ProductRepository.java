package com.study.servlet_study.repacitory;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entitiy.Product;

public class ProductRepository {
	private static ProductRepository instance;
	private List<Product> productList;
	
	private ProductRepository() {
		productList = new ArrayList<>();
	}
	
	public static ProductRepository getInstance() {
		if(instance == null) {
			instance = new ProductRepository();			
		}
		return instance;
	}
	
	public int saveProduct(Product product) {
		productList.add(product);
		return 1;
	}
	
	public Product findProductByProductName(String productName) {
		Product findProduct = null;
		
		for(Product product : productList) {
			if(product.getProductName().equals(productName)) {
				findProduct = product;
				break;
			}
		}
		
		return findProduct;
	}
}