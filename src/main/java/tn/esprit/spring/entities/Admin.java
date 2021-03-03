package tn.esprit.spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Admin extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String firstName, String lastName, String password,String email  ,String nameA) {
		super( firstName,  lastName, password,email );
	
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

}
