package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification implements Serializable{
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String titleN;
    private String contentN;
    
    @ManyToOne
    User users;
    
  

}
