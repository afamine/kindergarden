package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment implements Serializable{

	@EmbeddedId
	private AppointmentPK appointmentPK;
	
	
	//idG  :parent est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idParent",  insertable=false, updatable=false)
	private Parent parent;
	
	//idDirector :director est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idDirector",  insertable=false, updatable=false)
	private Director director;
	
	private String objetcR ;
	private String stateR;
	@Temporal(TemporalType.DATE)
	private Date date;
	public AppointmentPK getAppointmentPK() {
		return appointmentPK;
	}
	public void setAppointmentPK(AppointmentPK appointmentPK) {
		this.appointmentPK = appointmentPK;
	}

	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
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
