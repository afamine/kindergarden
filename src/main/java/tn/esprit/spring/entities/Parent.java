package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
//
@DiscriminatorValue("Parent")
public class Parent extends User implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateReg;
    private String adresse;
    private String etatCivil;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="parent")
    private List<Child> Child;
    
    /*@OneToOne(mappedBy="parent")
    private Garden garden;*/
    
    @OneToMany(mappedBy="parent")
	 private List<Inscription> inscriptions;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="parents")
    private List<Product> products;
    
	
    @OneToMany(mappedBy="parent")
	private List<Panier> paniers;
    
    
    
	
	
	

	



	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Parent(Long idU, String firstName, String lastName, String password, String email, String picture) {
		super(idU, firstName, lastName, password, email, picture);
		// TODO Auto-generated constructor stub
	}



	public Parent(String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		// TODO Auto-generated constructor stub
	}



	public Parent( Date dateReg, String adresse, String etatCivil, List<tn.esprit.spring.entities.Child> child,
			List<Inscription> inscriptions, List<Product> products, List<Panier> paniers) {
		super();
	
		this.dateReg = dateReg;
		this.adresse = adresse;
		this.etatCivil = etatCivil;
		Child = child;
		this.inscriptions = inscriptions;
		this.products = products;
		this.paniers = paniers;
	}



	



	public List<Child> getChild() {
		return Child;
	}



	public void setChild(List<Child> child) {
		Child = child;
	}



	public List<Inscription> getInscriptions() {
		return inscriptions;
	}



	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public List<Panier> getPaniers() {
		return paniers;
	}



	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}



	public Date getDateReg() {
		return dateReg;
	}
	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}


    
    
    
}
