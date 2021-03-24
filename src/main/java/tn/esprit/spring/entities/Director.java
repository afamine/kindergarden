package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Director extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numD;
	private String cv;
	@Temporal(TemporalType.DATE)
	private Date startYear;

	public Director() {
		super();
	}

	/*
	 * public Director(Long idU, String firstName, String lastName, String
	 * password,String email ,String picture, Boolean role,int numD,String cv,Date
	 * startYear) { super( idU,firstName, lastName, password,email,picture,role );
	 * 
	 * this.numD=numD; this.cv=cv; this.startYear=startYear;
	 * 
	 * }
	 */

	
	
	public int getNumD() {
		return numD;
	}

	public void setNumD(int numD) {
		this.numD = numD;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Date getStartYear() {
		return startYear;
	}

	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}

}
