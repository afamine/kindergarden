package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InscriptionPK implements Serializable{
	private static final long serialVersionUID = 5377539445871317492L;
	private int idGarden;
	private int idParent;
	public InscriptionPK() {
		super();
	}
	public InscriptionPK(int idGarden, int idParent) {
		super();
		this.idGarden = idGarden;
		this.idParent = idParent;
	}
	public int getIdGarden() {
		return idGarden;
	}
	public void setIdGarden(int idG) {
		this.idGarden = idG;
	}
	public int getIdParent() {
		return idParent;
	}
	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGarden;
		result = prime * result + idParent;
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
		InscriptionPK other = (InscriptionPK) obj;
		if (idGarden != other.idGarden)
			return false;
		if (idParent != other.idParent)
			return false;
		return true;
	}
	
	

}
