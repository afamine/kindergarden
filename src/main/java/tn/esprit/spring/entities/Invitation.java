package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Invitation  implements Serializable{
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Enumerated(EnumType.STRING)
	private Etat etat;
    public Etat getDomaine(){
    	return etat;
    }
	@OneToOne
	private Parent send;
	@OneToOne
	private Parent receive;
	
	
	public Invitation() {
		super();
	}
	
	public Invitation(long id, Etat etat, Parent send, Parent receive) {
		super();
		this.id = id;
		this.etat = etat;
		this.send = send;
		this.receive = receive;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Parent getSend() {
		return send;
	}
	public void setSend(Parent send) {
		this.send = send;
	}
	public Parent getReceive() {
		return receive;
	}
	public void setReceive(Parent receive) {
		this.receive = receive;
	}

}
