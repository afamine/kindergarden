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
public class Message implements Serializable {
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String objectM;
    private String contentM;
    @Temporal(TemporalType.DATE)
    private Date dateSend;
    private boolean msgLu;
    @ManyToOne
    User users;
    
    
	public Message() {
		super();
	}
	public Message(long id, String objectM, String contentM, Date dateSend, boolean msgLu) {
		super();
		this.id = id;
		this.objectM = objectM;
		this.contentM = contentM;
		this.dateSend = dateSend;
		this.msgLu = msgLu;
		
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", objectM=" + objectM + ", contentM=" + contentM + ", dateSend=" + dateSend
				+ ", msgLu=" + msgLu + "]";
	}
	
    
    ////hedhi 7ot'ha fi users
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    //private Set<Message> Messages;
   
    	
}
