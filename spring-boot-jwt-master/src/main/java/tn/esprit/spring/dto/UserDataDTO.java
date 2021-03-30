package tn.esprit.spring.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
import tn.esprit.spring.entities.Role;

public class UserDataDTO {
  

  private String username;

  private String email;

  private String password;

  List<Role> roles;
  private int numD;
  private String cv;
  @Temporal(TemporalType.DATE)
  private Date startYear ;
  private String specialite;
  private Long numDct;
  private Date dateReg;
  private String adresse;
  private String etatCivil;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

public int getNumD() {
	return numD;
}

public void setNumD(int numD) {
	this.numD = numD;
}

public String getCv() {
	return cv;
}

public void setCv(String cv) {
	this.cv = cv;
}

public Date getStartYear() {
	return startYear;
}

public void setStartYear(Date startYear) {
	this.startYear = startYear;
}

public String getSpecialite() {
	return specialite;
}

public void setSpecialite(String specialite) {
	this.specialite = specialite;
}

public Long getNumDct() {
	return numDct;
}

public void setNumDct(Long numDct) {
	this.numDct = numDct;
}

public Date getDateReg() {
	return dateReg;
}

public void setDateReg(Date dateReg) {
	this.dateReg = dateReg;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getEtatCivil() {
	return etatCivil;
}

public void setEtatCivil(String etatCivil) {
	this.etatCivil = etatCivil;
}

public UserDataDTO() {
	super();
}

}
