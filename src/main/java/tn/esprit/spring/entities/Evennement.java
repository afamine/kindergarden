package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evennement implements Serializable  {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nameEvt;
    private String adresseEvt ;
    @Temporal(TemporalType.DATE)
    private Date dateEvt;
    private String stateEvt;
   
    private String statusEvt;
    @OneToMany(mappedBy="evennement")
	private  List<Participation> participations;

}
