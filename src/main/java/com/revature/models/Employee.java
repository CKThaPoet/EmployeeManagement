package com.revature.models;

import java.io.Serializable;

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
	@Column
	private String jobtitle;
	@Column
	private String phone;
	@Column
	private String imageurl;

}
