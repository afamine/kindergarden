package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin extends User implements Serializable {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "idAdmin")
//	private Long idAdmin;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7160318028812132596L;

	public Admin(String username, String password, String email, String phone, String firstname, String lastname,
			String picture) {
		super();

	}

	public Admin() {
		super();

	}

	public Admin(String firstName, String lastName, String password, String email, Long idAdmin) {
		super();
		// this.idAdmin = idAdmin;
	}

//	public Long getIdAdmin() {
//		return idAdmin;
//	}
//
//	public void setIdAdmin(Long idAdmin) {
//		this.idAdmin = idAdmin;
//	}
//	

}
