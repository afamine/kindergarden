package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
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
    private Parent parent;
    @OneToOne
    private Doctor doctor;
    @OneToOne
    private Director director;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="garden")
    private List<Activity> Activitys;
	@JsonIgnore
	@OneToMany(mappedBy="garden")
	private List<Participation> participations;

	@OneToMany(mappedBy="garden")
	private List<Inscription> inscriptions;
	@OneToMany(mappedBy="garden")
	private List<Registration> registrations;
}
