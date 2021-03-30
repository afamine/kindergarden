package tn.esprit.spring.dto;

public class ChildDTO {
	private Long idC;
	private String firstname;
	private String lastname;
	private Integer age;
	private String sex;
	private String picture;
	public Long getIdC() {
		return idC;
	}
	public void setIdC(Long idC) {
		this.idC = idC;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public ChildDTO() {
		super();
	}
	
}
