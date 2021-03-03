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
public class Publication implements Serializable {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String contentPub;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String subjectD;
    private String typeD;
    private String statusD;
  
    @ManyToOne
    User users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="publications")
    private List<Reaction> Reactions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="publications")
    private List<Comment> Comments;
    @ManyToOne
    CategoryForum categoryForum;
    public Publication() {
		super();
	}


	public Publication(long id, String contentPub, Date date, User users) {
		super();
		this.id = id;
		this.contentPub = contentPub;
		this.date = date;
		this.users = users;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getContentPub() {
		return contentPub;
	}


	public void setContentPub(String contentPub) {
		this.contentPub = contentPub;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}
	
    
    

   
    	
}
