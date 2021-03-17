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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date dateCmt;
    private String status;
    private int nbCmt;
   
    @ManyToOne
    Publication publications;
    @ManyToOne
    User users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="comments")
    private List<Reaction> reactions;
    
}
