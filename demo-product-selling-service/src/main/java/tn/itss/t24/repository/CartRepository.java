package tn.itss.t24.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.itss.t24.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>{

	public List<Cart> findCartsByClientId(String client_id);
}
