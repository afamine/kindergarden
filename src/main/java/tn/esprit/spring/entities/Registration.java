package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Registration  implements Serializable{
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@EmbeddedId
	private RegistrationPK registrationPK;
	
	//idG  :garden est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idGarden", referencedColumnName = "id", insertable=false, updatable=false)
	private Garden garden;
	
	//idEvt :Bus est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "id", insertable=false, updatable=false)
	private Bus bus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RegistrationPK getRegistrationPK() {
		return registrationPK;
	}

	public void setRegistrationPK(RegistrationPK registrationPK) {
		this.registrationPK = registrationPK;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}
