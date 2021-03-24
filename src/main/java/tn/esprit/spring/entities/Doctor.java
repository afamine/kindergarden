package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Doctor extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8266175559839518259L;

	private String specialite;
	private Long numDct;
	
	
	

	/*
	 * public Doctor(Long idU, String firstName, String lastName, String password,
	 * String email,String picture,Boolean role, String specialite, Long numDct) {
	 * super(idU, firstName, lastName, password, email, picture, role);
	 * 
	 * this.specialite = specialite; this.numDct = numDct; }
	 */

	public Doctor() {
		super();
		
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
