package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Bus implements Serializable {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nameDriver ;
    private String depart;
    private String arrival;
    private String path;
    private String rateb;
    private String registrationBus;
	@OneToMany(mappedBy="bus")
	private List<Registration> registrations;
    
    
    
}
