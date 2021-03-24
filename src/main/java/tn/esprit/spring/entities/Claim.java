package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Claim implements Serializable {
	
	
	
  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String subjectC;
    private String contentC;
    @Temporal(TemporalType.DATE)
    private Date dateC;
    @Enumerated(EnumType.STRING)
    private StateClaim stateC;
    @Enumerated(EnumType.STRING)
    private TypeClaim type;
   
    @ManyToOne()
    User user;
    
    

	public Claim() {
		super();
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public String getSubjectC() {
		return subjectC;
	}


	public void setSubjectC(String subjectC) {
		this.subjectC = subjectC;
	}


	public String getContentC() {
		return contentC;
	}


	public void setContentC(String contentC) {
		this.contentC = contentC;
	}


	public Date getDateC() {
		return dateC;
	}


	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}


	


	


	public StateClaim getStateC() {
		return stateC;
	}



	public void setStateC(StateClaim stateC) {
		this.stateC = stateC;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public TypeClaim getType() {
		return type;
	}


	public void setType(TypeClaim type) {
		this.type = type;
	}
	
	
	
    
    

   
    	
}
