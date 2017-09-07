package com.yusuf.es.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Document(indexName = "appdb", type = "instructor", shards = 1, replicas = 0)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
	private String surname;
	private String mobile;
	private String title;
	private int office;
	private String email;
	@Column
	@ElementCollection(targetClass=Lecture.class)
	private List<Lecture> instructedLectures;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Lecture> getInstructedLectures() {
		return instructedLectures;
	}
	public void setInstructedLectures(List<Lecture> instructedLectures) {
		this.instructedLectures = instructedLectures;
	}



}
