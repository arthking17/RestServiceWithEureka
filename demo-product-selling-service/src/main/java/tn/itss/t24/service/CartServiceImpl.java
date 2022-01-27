package tn.itss.t24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itss.t24.model.Cart;
import tn.itss.t24.repository.CartRepository;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public void addToCart(Cart c) {
		cartRepo.save(c);		
	}

	@Override
	public List<Cart> showCart(String client_id) {
		//List<Cart> allCart = cartRepo.findAll();
		List<Cart> allCart = cartRepo.findCartsByClientId(client_id);
		
		return allCart;
	}

}
