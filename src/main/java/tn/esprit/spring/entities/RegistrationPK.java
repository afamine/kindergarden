package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RegistrationPK implements Serializable{
	private static final long serialVersionUID = 5377539445871317492L;

	private int idBus;
	private int idGarden;
	public RegistrationPK() {
		super();
	}
	public RegistrationPK(int idBus, int idGarden) {
		super();
		this.idBus = idBus;
		this.idGarden = idGarden;
	}
	public int getIdBus() {
		return idBus;
	}
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	public int getIdGarden() {
		return idGarden;
	}
	public void setIdGarden(int idGarden) {
		this.idGarden = idGarden;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBus;
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
		RegistrationPK other = (RegistrationPK) obj;
		if (idBus != other.idBus)
			return false;
		if (idGarden != other.idGarden)
			return false;
		return true;
	}

}
