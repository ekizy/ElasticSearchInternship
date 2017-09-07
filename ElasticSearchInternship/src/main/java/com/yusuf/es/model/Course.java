package com.yusuf.es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Document(indexName = "appdb", type = "course", shards = 1, replicas = 0)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	private String courseName;
	private String courseCode;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
