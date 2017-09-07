package com.yusuf.es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.elasticsearch.annotations.Document;


@Entity
@Document(indexName = "appdb", type = "lecture", shards = 1, replicas = 0)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String language;
	private String classRoom;
	private String dayTime;
	@OneToOne
	@Cascade({CascadeType.ALL})
	private Instructor instructor;
	@OneToOne
	@Cascade({CascadeType.ALL})
	private Course course;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getDayTime() {
		return dayTime;
	}
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
