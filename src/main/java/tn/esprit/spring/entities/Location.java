package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Location  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idL")
	private Long idL;
	private String  adresse;
	private float latitude;
	private float longitude;
	
    @ManyToOne
    User users;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long idL, String adresse, float latitude, float longitude, User users) {
		super();
		this.idL = idL;
		this.adresse = adresse;
		this.latitude = latitude;
		this.longitude = longitude;
		this.users = users;
	}

	public Long getIdL() {
		return idL;
	}

	public void setIdL(Long idL) {
		this.idL = idL;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
