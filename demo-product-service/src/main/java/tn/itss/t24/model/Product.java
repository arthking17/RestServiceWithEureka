package tn.itss.t24.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {

	@Id
	private String id;
	private String name;
	private int qte;
	private Date created_date;
	private float price;
	
	public Product() {
		super();
	}

	public Product(String id, String name, int qte, Date created_date, float price) {
		super();
		this.id = id;
		this.name = name;
		this.qte = qte;
		this.created_date = created_date;
		this.price = price;
	}

	public Product(String name, int qte, Date created_date, float price) {
		super();
		this.name = name;
		this.qte = qte;
		this.created_date = created_date;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qte=" + qte + ", created_date=" + created_date + ", price="
				+ price + "]";
	}
	
}
