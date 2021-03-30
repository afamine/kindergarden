package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Claim implements Serializable {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String subjectC;
    private String contentC;
    @Temporal(TemporalType.DATE)
    private Date dateC;
    private String stateC;
   
    @ManyToOne
    User users;
    
    

	public Claim() {
		super();
	}
	
	
	public Claim(long id, String subjectC, String contentC, Date dateC, String stateC, User users) {
		super();
		this.id = id;
		this.subjectC = subjectC;
		this.contentC = contentC;
		this.dateC = dateC;
		this.stateC = stateC;
		this.users = users;
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


	public String getStateC() {
		return stateC;
	}


	public void setStateC(String stateC) {
		this.stateC = stateC;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}
	
    
    

   
    	
}
