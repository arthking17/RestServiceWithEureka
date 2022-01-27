package tn.itss.t24.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clients")
public class Client {
	
	@Id
	private String id;
	private String name;
	private String cin;
	private int age;
	private String rib;
	private Date last_connexion;
	
	public Client(String id, String name, String cin, int age, String rib, Date last_connexion) {
		super();
		this.id = id;
		this.name = name;
		this.cin = cin;
		this.age = age;
		this.rib = rib;
		this.last_connexion = last_connexion;
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public Date getLast_connexion() {
		return last_connexion;
	}

	public void setLast_connexion(Date last_connexion) {
		this.last_connexion = last_connexion;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cin=" + cin + ", age=" + age + ", rib=" + rib
				+ ", last_connexion=" + last_connexion + "]";
	}
	
	
}
