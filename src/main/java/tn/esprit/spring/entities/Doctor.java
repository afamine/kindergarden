package tn.esprit.spring.entities;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("Doctor")
public class Doctor extends User implements Serializable   {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String specialite;
	private Long numDct;
	@OneToOne(mappedBy="doctor")
	private Garden garden;
	

	 
	
	

	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Doctor(Long idU, String firstName, String lastName, String password, String email, String picture) {
		super(idU, firstName, lastName, password, email, picture);
		// TODO Auto-generated constructor stub
	}




	public Doctor(String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		// TODO Auto-generated constructor stub
	}




	public Doctor( String specialite, Long numDct, Garden garden) {
		super();
		
		this.specialite = specialite;
		this.numDct = numDct;
		this.garden = garden;
	}









	public Garden getGarden() {
		return garden;
	}




	public void setGarden(Garden garden) {
		this.garden = garden;
	}




	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Long getNumDct() {
		return numDct;
	}
	public void setNumDct(Long numDct) {
		this.numDct = numDct;
	}
	
	
}
