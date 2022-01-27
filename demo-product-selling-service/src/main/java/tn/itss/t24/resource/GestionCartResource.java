package tn.itss.t24.resource;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import tn.itss.t24.model.Cart;
import tn.itss.t24.model.Product;
import tn.itss.t24.service.ICartService;
import tn.itss.t24.service.SequenceGeneratorService;

@RestController
@RequestMapping("/cart")
public class GestionCartResource {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	ICartService cartService;

	@Autowired
	private RestTemplate restTemplate;

	boolean verif = true;

	@Autowired
	SequenceGeneratorService generatedId;

	private static final Logger l = LogManager.getLogger(GestionCartResource.class);

	@RequestMapping("/add/{client_id}/{product_id}/{qte}")
	public boolean addToCart(@PathVariable("client_id") String client_id, @PathVariable("product_id") String product_id,
			@PathVariable("qte") int qte) {

		// Client c =
		// restTemplate.getForObject("http://localhost:8081/clients/"+client_id,
		// Client.class);
		// Product p =
		// restTemplate.getForObject("http://gestion-product-service:8082/products/" +
		// product_id, Product.class);

		Product p = webClientBuilder.build().get().uri("http://gestion-product-service/products/" + product_id)
				.retrieve().bodyToMono(Product.class).block();

		// System.out.print("ddsd"+p);
		Cart cart = new Cart(generatedId.generateSequence("cart"), product_id, client_id, qte);

		if (p.getQte() < qte)
			return false;
		else {
			cartService.addToCart(cart);
			return true;
		}
	}

	@RequestMapping("/{client_id}")
	public List<Cart> showCart(@PathVariable("client_id") String client_id) {
		return cartService.showCart(client_id);
	}

	@RequestMapping("/checkout/{client_id}")
	public boolean checkout(@PathVariable("client_id") String client_id) {
		List<Cart> carts = cartService.showCart(client_id);
		carts.forEach(c -> {
			verif = restTemplate.getForObject(
					"http://gestion-product-service/products/sell/" + c.getProductId() + "/" + c.getQte() * (-1),
					boolean.class);
		});
		return verif;
	}
}
