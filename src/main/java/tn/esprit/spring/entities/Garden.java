package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Garden implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="garden")
	private Set<Child> child;
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id_garden;
	private String name;
	private String logo;
	private String adresse;
	private int num;
	private String mail;
    @Temporal(TemporalType.DATE)
	private Date dateCreation;
    private String description;
    public float rate;
    
  
    @OneToOne
    private Doctor doctor;
    
    @OneToOne
    private Director director;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="garden")
    private List<Activity> Activitys;
    
	/*@JsonIgnore
	@OneToMany(mappedBy="garden")
	private List<Participation> participations;

	@OneToMany(mappedBy="garden")
	private List<Inscription> inscriptions;
	
	@OneToMany(mappedBy="garden")
	private List<Registration> registrations;*/
	


	public Garden(Set<Child> child, long id_garden, String name, String logo, String adresse, int num, String mail,
			Date dateCreation, String description, float rate, Doctor doctor, Director director,
			List<Activity> activitys) {
		super();
		this.child = child;
		this.id_garden = id_garden;
		this.name = name;
		this.logo = logo;
		this.adresse = adresse;
		this.num = num;
		this.mail = mail;
		this.dateCreation = dateCreation;
		this.description = description;
		this.rate = rate;
		this.doctor = doctor;
		this.director = director;
		Activitys = activitys;
	}
		

	public Garden() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}

	

	public long getId_garden() {
		return id_garden;
	}

	public void setId_garden(long id_garden) {
		this.id_garden = id_garden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Activity> getActivitys() {
		return Activitys;
	}

	public void setActivitys(List<Activity> activitys) {
		Activitys = activitys;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
}
