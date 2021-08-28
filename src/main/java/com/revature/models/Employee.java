package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//using serializable so it can turn this java class into different type of stream
//Lombok is in the dependencies but I decided to do them manually
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column(name = "job_title")
	private String jobtitle;
	@Column
	private String phone;
	@Column(name = "image_url")
	private String imageurl;
	

	//boiler plate code with getters and getters *can use Lombok instead in the future if I change my mind
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Long id, String name, String email, String jobtitle, String phone, String imageurl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobtitle = jobtitle;
		this.phone = phone;
		this.imageurl = imageurl;
	}


	public Employee(String name, String email, String jobtitle, String phone, String imageurl) {
		super();
		this.name = name;
		this.email = email;
		this.jobtitle = jobtitle;
		this.phone = phone;
		this.imageurl = imageurl;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", jobtitle=" + jobtitle + ", phone="
				+ phone + ", imageurl=" + imageurl + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, imageurl, jobtitle, name, phone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(imageurl, other.imageurl) && Objects.equals(jobtitle, other.jobtitle)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJobtitle() {
		return jobtitle;
	}


	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
}
