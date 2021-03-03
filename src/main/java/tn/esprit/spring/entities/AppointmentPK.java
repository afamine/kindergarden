package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class AppointmentPK implements Serializable{
	private static final long serialVersionUID = 5377539445871317492L;

	private int idDirector;
	private int idParent;
	public AppointmentPK() {
		super();
	}
	public AppointmentPK(int idDirector, int idParent) {
		super();
		this.idDirector = idDirector;
		this.idParent = idParent;
	}
	public int getIdDirector() {
		return idDirector;
	}
	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
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
		result = prime * result + idDirector;
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
		AppointmentPK other = (AppointmentPK) obj;
		if (idDirector != other.idDirector)
			return false;
		if (idParent != other.idParent)
			return false;
		return true;
	}
	
	

}
