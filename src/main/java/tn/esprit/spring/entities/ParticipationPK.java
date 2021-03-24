package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Embeddable;
@Embeddable
public class ParticipationPK implements Serializable{
	private static final long serialVersionUID = 5377539445871317492L;

	private int idGarden;
	private int idEvt;
	
	
	public ParticipationPK() {
		super();
	}

	public ParticipationPK(int idGarden, int idEvt) {
		super();
		this.idGarden = idGarden;
		this.idEvt = idEvt;
		
	}

	public int getIdGarden() {
		return idGarden;
	}

	public void setIdGarden(int idG) {
		this.idGarden = idGarden;
	}

	public int getIdEvt() {
		return idEvt;
	}

	public void setIdEvt(int idEvt) {
		this.idEvt = idEvt;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvt;
		result = prime * result + idGarden;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipationPK other = (ParticipationPK) obj;
		if (idEvt != other.idEvt)
			return false;
		if (idGarden != other.idGarden)
			return false;
		return true;
	}

	
	
	
}
