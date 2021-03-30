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
public class Inscription implements Serializable{

	@EmbeddedId
	private InscriptionPK InscriptionPK;
	
	
	//idG  :garden est a la fois primary key et foreign key
		@ManyToOne
	    @JoinColumn(name = "idGarden", referencedColumnName = "id", insertable=false, updatable=false)
		private Garden garden;
		
		//idParent :doctor est a la fois primary key et foreign key
		@ManyToOne
	    @JoinColumn(name = "idCh",  insertable=false, updatable=false)
		private Child child;


		public InscriptionPK getInscriptionPK() {
			return InscriptionPK;
		}

		public void setInscriptionPK(InscriptionPK inscriptionPK) {
			InscriptionPK = inscriptionPK;
		}

		public Garden getGarden() {
			return garden;
		}

		public void setGarden(Garden garden) {
			this.garden = garden;
		}

		public Child getChild() {
			return child;
		}

		public void setChild(Child child) {
			this.child = child;
		}

}
