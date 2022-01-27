package tn.itss.t24.service;

import java.util.List;

import tn.itss.t24.model.Product;


public interface IProductService {
	public List<Product> getAllProducts();
	public Product addProduct(Product p);
	public void deleteProduct(String id);
	public Product updateProduct(Product p);
	public Product getProduct(String id);
	public List<Product> allProductOutOfStock();

}
