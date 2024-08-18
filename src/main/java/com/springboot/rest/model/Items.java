package com.springboot.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String iname;
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Items(long id, String iname, String description) {
		
		this.id = id;
		this.iname = iname;
		this.description = description;
	}
	public Items() {
		
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", iname=" + iname + ", description=" + description + "]";
	}
	
	
	
}
