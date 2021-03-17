package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Appointment implements Serializable{

	
	
	/*@ManyToOne
	Child child;*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idR;
	private String objetcR ;
	private String stateR;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	//@JsonManagedReference
	@ManyToOne
	Child child;
	
	
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	



	public Appointment(long idR, String objetcR, String stateR, Date date, Child child) {
		super();
		this.idR = idR;
		this.objetcR = objetcR;
		this.stateR = stateR;
		this.date = date;
		this.child = child;
	}











	public long getIdR() {
		return idR;
	}



	public void setIdR(long idR) {
		this.idR = idR;
	}


	
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	public String getObjetcR() {
		return objetcR;
	}
	public void setObjetcR(String objetcR) {
		this.objetcR = objetcR;
	}
	public String getStateR() {
		return stateR;
	}
	public void setStateR(String stateR) {
		this.stateR = stateR;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	

	
}
