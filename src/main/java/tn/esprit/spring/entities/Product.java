package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String nomProd;
	private int stock;
	private int prix;
	private String image;
	   @ManyToOne
	    Parent parents;
	   @ManyToOne
	    Director directors;
	   @OneToMany(mappedBy="product")
		private List<Panier> paniers;
}
