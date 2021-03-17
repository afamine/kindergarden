package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Child  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@OneToMany(cascade = CascadeType.ALL, mappedBy="child")
	private Set<Appointment> Appointments;

	
	@ManyToOne
	Garden garden;
	
	@ManyToOne
	Parent parent;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idC")
	private Long idC;
	private String firstname;
	private String lastname;
	private Integer age;
	private String sex;
	private String picture;
	

	
	public Child() {
		super();
	}
	
	
	
	public Child(Set<Appointment> appointments, Garden garden, Parent parent, Long idC, String firstname,
			String lastname, Integer age, String sex, String picture) {
		super();
		Appointments = appointments;
		this.garden = garden;
		this.parent = parent;
		this.idC = idC;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.sex = sex;
		this.picture = picture;
	}



	public Long getIdC() {
		return idC;
	}
	public void setIdC(Long idC) {
		this.idC = idC;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
	public Set<Appointment> getAppointments() {
		return Appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		Appointments = appointments;
	}
	
	
}
