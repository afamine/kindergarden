package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idU")
	private Long idU;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(name = "email", unique = true)
	private String email;
	private String picture;
	@Enumerated (EnumType.STRING)
	private Role role;
    public Role getDomaine(){
    	return role;
    }
    public enum Role{
 		CHEF_DEPARTEMENT, ADMINISTRATEUR, INGENIEUR,
 		}
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Message> Messages;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Notification> Notifications;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Claim> Claims;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Location> locations;
    

    
	public User() {
		super();
	}
	
	public User(Long idU, String firstName, String lastName, String password, String email ,String picture) {
		super();
		this.idU = idU;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.picture=picture;
	
	}
	
	
	public User(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	public Long getIdU() {
		return idU;
	}
	public void setIdU(Long idU) {
		this.idU = idU;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Enum getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Message> getMessages() {
		return Messages;
	}

	public void setMessages(List<Message> messages) {
		Messages = messages;
	}

	public List<Notification> getNotifications() {
		return Notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		Notifications = notifications;
	}

	public List<Claim> getClaims() {
		return Claims;
	}

	public void setClaims(List<Claim> claims) {
		Claims = claims;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

 
}
