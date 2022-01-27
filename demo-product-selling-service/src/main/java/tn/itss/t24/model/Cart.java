package tn.itss.t24.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("carts")
public class Cart {

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private long id;
	private String productId;
	private String clientId;
	private int qte;
	
	public Cart(long id, String productId, String clientId, int qte) {
		super();
		this.id = id;
		this.productId = productId;
		this.clientId = clientId;
		this.qte = qte;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
}
