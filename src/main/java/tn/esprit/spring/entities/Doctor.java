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
public class Doctor extends User   {

	private String specialite;
	private Long numDct;
	@OneToOne(mappedBy="doctor")
	private Garden garden;
	

	 
	public Doctor( String firstName, String lastName, String password, String email, 
			String specialite, Long numDct) {
		super(firstName, lastName, password, email);
	
		this.specialite = specialite;
		this.numDct = numDct;
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
