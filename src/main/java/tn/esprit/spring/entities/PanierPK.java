package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PanierPK implements Serializable{
	private static final long serialVersionUID = 5377539445871317492L;

	private int idParent;
	private int idProduct;
	
	public PanierPK() {
		super();
	}

	public PanierPK(int idParent, int idProduct) {
		super();
		this.idParent = idParent;
		this.idProduct = idProduct;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idParent;
		result = prime * result + idProduct;
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
		PanierPK other = (PanierPK) obj;
		if (idParent != other.idParent)
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}
	
	
	
}
