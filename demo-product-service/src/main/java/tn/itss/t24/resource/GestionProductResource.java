package tn.itss.t24.resource;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.itss.t24.model.Product;
import tn.itss.t24.service.IProductService;

@RestController
@RequestMapping("/products")
public class GestionProductResource {

	@Autowired
	IProductService ps;

	private static final Logger l = LogManager.getLogger(GestionProductResource.class);

	@RequestMapping("")
	public List<Product> getAllProducts() {
		return ps.getAllProducts();
	}

	@RequestMapping("/{product_id}")
	public Product getProduct(@PathVariable("product_id") String product_id) {
		Product p = ps.getProduct(product_id);
		l.debug("retrieved product : " + p);
		return p;
	}

	@PostMapping("/new")
	ResponseEntity<Product> addProduct(@RequestBody Product p) {
		// EntityModel
		p = ps.addProduct(p);
		l.debug("product added : " + p);
		return ResponseEntity.ok(p);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product p) {
		p = ps.updateProduct(p);
		l.debug("Product updated : " + p);
		return ResponseEntity.ok(p);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id) {
		ps.deleteProduct(id);
		l.debug("Product deleted : id= " + id);
		return ResponseEntity.ok("Product Deleted");
	}

	@PutMapping("/sell/{id}/{qte}")
	public void sellProduct(@PathVariable("id") String id, @PathVariable("qte") int qte) {
		Product p = ps.getProduct(id);
		if (p.getQte() - qte >= 0) {
			p.setQte(p.getQte() - qte);
			ps.updateProduct(p);
			l.debug("Il reste : " + p.getQte() + " en stock");
		} else {
			l.debug("Action impossible !!! pas assez de stock.");
		}
	}
}
