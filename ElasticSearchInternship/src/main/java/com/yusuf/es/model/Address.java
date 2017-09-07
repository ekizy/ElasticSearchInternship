package com.yusuf.es.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Entity
//@Document(indexName = "appdb", type = "address", shards = 1, replicas = 0)
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String country;
	private String city;
	private String street;
	private int pincode;
	private int userID;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
