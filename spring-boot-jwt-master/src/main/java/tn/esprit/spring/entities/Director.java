package tn.esprit.spring.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Director  extends User {
private int numD;
private String cv;
@Temporal(TemporalType.DATE)
private Date startYear ;

	public Director() {
		super();
	}

	/*public Director(Long idU, String firstName, String lastName, String password,String email  ,String picture, Boolean role,int numD,String cv,Date startYear) {
		super( idU,firstName,  lastName, password,email,picture,role );
	
		this.numD=numD;
		this.cv=cv;
		this.startYear=startYear;
		
	}*/

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
