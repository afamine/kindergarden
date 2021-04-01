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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String objectM;
    private String contentM;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSend ;
    private boolean msgLu;
    private String fr;
    private String picture;
   // @ManyToOne
    //User users;
    @ManyToOne
    private User users;
    @OneToOne
    private User user;
 
    
	public Message() {
		super();
	}

@PrePersist
private void onCreate(){dateSend = new Date();}



	public Message(String objectM, String contentM) {
	super();
	this.objectM = objectM;
	this.contentM = contentM;
}

	public Message(String objectM, String contentM, User user) {
		super();
		this.objectM = objectM;
		this.contentM = contentM;
		this.user = user;
	}

	public Message(long id) {
	super();
	this.id = id;
}

	public Message(long id, String objectM, String contentM, Date dateSend, boolean msgLu, String fr, User users) {
		super();
		this.id = id;
		this.objectM = objectM;
		this.contentM = contentM;
		this.dateSend = dateSend;
		this.msgLu = msgLu;
		this.fr = fr;
		this.users = users;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getObjectM() {
		return objectM;
	}


	public void setObjectM(String objectM) {
		this.objectM = objectM;
	}


	public String getContentM() {
		return contentM;
	}


	public void setContentM(String contentM) {
		this.contentM = contentM;
	}


	public Date getDateSend() {
		return dateSend;
	}


	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}


	public boolean isMsgLu() {
		return msgLu;
	}


	public void setMsgLu(boolean msgLu) {
		this.msgLu = msgLu;
	}


	public String getFr() {
		return fr;
	}


	public void setFr(String fr) {
		this.fr = fr;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}

















    
    ////hedhi 7ot'ha fi users
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    //private Set<Message> Messages;
   
    	
}
