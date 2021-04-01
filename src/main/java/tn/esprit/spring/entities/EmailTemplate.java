package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/*
 * @Author Debu Paul
 */


public class EmailTemplate {
	
	private String sendTo;
	
	private String subject;
	
	private String body;
	private MultipartFile picture;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSend ;
    @PrePersist
    private void onCreate(){dateSend = new Date();}
	
	


	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	

	public EmailTemplate(String sendTo, String subject, String body) {
		super();
		this.sendTo = sendTo;
		this.subject = subject;
		this.body = body;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}




	public Date getDateSend() {
		return dateSend;
	}




	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}



	

	

}
