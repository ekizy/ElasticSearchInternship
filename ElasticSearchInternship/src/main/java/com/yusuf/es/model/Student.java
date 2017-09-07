package com.yusuf.es.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Document(indexName = "esdb", type = "student", shards = 1, replicas = 0)  // doküman'ın index'i yazıldı(esdb)
public class Student {

	// eşsiz bir id değeri olması sağlandı. otomatik oluşturulur.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String hobby;
	/*@OneToOne
	@Cascade({CascadeType.ALL})
    private Address address;
	@OneToMany
	@Cascade({CascadeType.ALL})
    private List <Lecture> enrolledLectures;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List <Lecture> getEnrolledLectures() {
		return enrolledLectures;
	}

	public void setEnrolledLectures(List <Lecture> enrolledLectures) {
		this.enrolledLectures = enrolledLectures;
	}*/
}
