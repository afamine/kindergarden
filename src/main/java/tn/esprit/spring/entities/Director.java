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
public class Director  extends User {
private int numD;
private String cv;
@Temporal(TemporalType.DATE)
private Date startYear ;
@OneToOne(mappedBy="director")
private Garden garden;

@OneToMany(cascade = CascadeType.ALL, mappedBy="directors")
private List<Product> products;
@OneToMany(mappedBy="director")
private List<Appointment> appointments;
	public Director() {
		super();
	}

	public Director(String firstName, String lastName, String password,String email  ,int numD,String cv,Date startYear) {
		super( firstName,  lastName, password,email );
	
		this.numD=numD;
		this.cv=cv;
		this.startYear=startYear;
		
	}

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
