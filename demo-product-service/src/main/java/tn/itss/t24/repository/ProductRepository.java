package tn.itss.t24.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.itss.t24.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
