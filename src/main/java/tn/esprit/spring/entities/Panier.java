package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Panier implements Serializable {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@EmbeddedId
	private PanierPK panierPK;
	

	//idParent  :Parent est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idParent",  insertable=false, updatable=false)
	private Parent parent;
	
	//idProduct :Product est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", insertable=false, updatable=false)
	private Product product;

	private float total;
	private String state;
	public PanierPK getPanierPK() {
		return panierPK;
	}

	public void setPanierPK(PanierPK panierPK) {
		this.panierPK = panierPK;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
}
