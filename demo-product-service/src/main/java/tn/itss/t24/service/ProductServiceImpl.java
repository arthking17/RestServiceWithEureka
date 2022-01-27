package tn.itss.t24.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itss.t24.model.Product;
import tn.itss.t24.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepo;
	private static final Logger l = LogManager.getLogger(IProductService.class);

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		try {

			l.info("In getAllProducts() : ");
			products = (List<Product>) productRepo.findAll();
			for (Product product : products) {
				l.debug("product +++ : " + product);
			}
			l.info("Out of getAllProducts() : ");
		} catch (Exception e) {
			l.error("Error in getAllProducts() : " + e);
		}

		return products;
	}

	@Override
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}

	@Override
	public void deleteProduct(String id) {
		productRepo.deleteById(id);
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}

	@Override
	public Product getProduct(String id) {
		l.info("in  getProduct id = " + id);
		Product p = productRepo.findById(id).orElse(null);
		l.info("product returned : " + p);
		return p;
	}

	@Override
	public List<Product> allProductOutOfStock() {

		//productRepo.findAll().forEach();;

		return null;
	}

}
