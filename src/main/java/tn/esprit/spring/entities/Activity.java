package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Activity implements Serializable   {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name ;
	private String type;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String picture;
	private String nameAnimator;
    @ManyToOne
    Garden garden;

}
