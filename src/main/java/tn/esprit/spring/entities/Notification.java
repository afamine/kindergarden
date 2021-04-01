package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Notification implements Serializable{
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String titleN;
    private String contentN;
    private boolean msgLu;
    //private String to;
    
    @ManyToOne
    User users;
    @OneToOne
    private User user;
	public Notification() {
		super();
	}


	public Notification(String titleN, String contentN) {
		super();
		this.titleN = titleN;
		this.contentN = contentN;
	}
	



	public Notification(String titleN, String contentN, User users) {
		super();
		this.titleN = titleN;
		this.contentN = contentN;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitleN() {
		return titleN;
	}

	public void setTitleN(String titleN) {
		this.titleN = titleN;
	}

	public String getContentN() {
		return contentN;
	}

	public void setContentN(String contentN) {
		this.contentN = contentN;
	}

	public boolean isMsgLu() {
		return msgLu;
	}

	public void setMsgLu(boolean msgLu) {
		this.msgLu = msgLu;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}





	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




    
    

}
