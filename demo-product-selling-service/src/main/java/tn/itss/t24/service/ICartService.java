package tn.itss.t24.service;

import java.util.List;

import tn.itss.t24.model.Cart;

public interface ICartService {

	public void addToCart(Cart c);
	public List<Cart> showCart(String client_id);
}
