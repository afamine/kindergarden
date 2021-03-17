package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("Director")
//zedt implements Serializable 
public class Director  extends User implements Serializable {
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int numD;
private String cv;
@Temporal(TemporalType.DATE)
private Date startYear ;


@OneToMany(cascade = CascadeType.ALL, mappedBy="directors")
private List<Product> products;



	public Director() {
		super();
	}

	
	
	

	public Director(int numD, String cv, Date startYear, List<Product> products) {
		super();
		this.numD = numD;
		this.cv = cv;
		this.startYear = startYear;
		this.products = products;
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
