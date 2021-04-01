package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@DiscriminatorValue( "not null" )
public class Parent extends User {

    private Date dateReg;
    private String adresse;
    private String etatCivil;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="parent")
    private List<Child> Child;
    
    @OneToOne(mappedBy="parent")
    private Garden garden;
    @OneToMany(mappedBy="parent")
	 private List<Inscription> inscriptions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="parents")
    private List<Product> products;
	@OneToMany(mappedBy="parent")
	private List<Appointment> appointments;
    @OneToMany(mappedBy="parent")
	private List<Panier> paniers;
    


    @OneToMany(mappedBy = "proprietaire",
    cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<Parent> parentlist;

    @ManyToOne (fetch = FetchType.LAZY)
    private Parent proprietaire;
    
    
    
	public Parent() {
		super();
	}

	public Parent(String firstName, String lastName, String password, String email,  Date dateReg,
			String adresse, String etatCivil) {
		super( firstName, lastName, password, email);
		
		this.dateReg = dateReg;
		this.adresse = adresse;
		this.etatCivil = etatCivil;
		
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

	public List<Child> getChild() {
		return Child;
	}

	public void setChild(List<Child> child) {
		Child = child;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public Set<Parent> getParentlist() {
		return parentlist;
	}

	public void setParentlist(Set<Parent> parentlist) {
		this.parentlist = parentlist;
	}

	public Parent getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Parent proprietaire) {
		this.proprietaire = proprietaire;
	}


    
    
    
}
