package tn.esprit.spring.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
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


    
    
    
}
