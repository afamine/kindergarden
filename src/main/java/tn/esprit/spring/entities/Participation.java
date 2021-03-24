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
public class Participation  implements Serializable{
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@EmbeddedId
	private ParticipationPK participationPK;
	
	//idGarden  :garden est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idGarden", referencedColumnName = "id", insertable=false, updatable=false)
	private Garden garden;
	
	//idEvt :evennement est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idEvt", referencedColumnName = "id", insertable=false, updatable=false)
	private Evennement evennement;
	
	private int nbrParticipant;

	public ParticipationPK getParticipationPK() {
		return participationPK;
	}

	public void setParticipationPK(ParticipationPK participationPK) {
		this.participationPK = participationPK;
	}

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Evennement getEvennement() {
		return evennement;
	}

	public void setEvennement(Evennement evennement) {
		this.evennement = evennement;
	}

	public int getNbrParticipant() {
		return nbrParticipant;
	}

	public void setNbrParticipant(int nbrParticipant) {
		this.nbrParticipant = nbrParticipant;
	}
	
}
