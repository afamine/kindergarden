package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Parent extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4582495806072842620L;

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idParent")
	private Long idParent;*/

    private Date dateReg;
    private String adresse;
    private String etatCivil;
    
//    @OneToMany
//    private List<Order>orders = new ArrayList<Order>();
 
    
    
    
  
//    public Parent(String username, String password, String email, String phone, String firstname, String lastname, String picture) {
//		super();
//
//	}
//    public Parent( String firstName, String lastName, String password, String email, Long idParent,Date dateReg,String adresse,String etatcivil) {
//		super();
//	//	this.idParent = idParent;
//		this.dateReg=dateReg;
//		this.adresse=adresse;
//		this.etatCivil=etatCivil;
//	}

	public Parent() {
		super();
		
	}
	public Date getDateReg() {
		return dateReg;
	}
	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}
//	public List<Order> getOrders() {
//		return orders;
//	}
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}


    
    
    
}
