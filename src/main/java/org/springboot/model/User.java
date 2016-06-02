package org.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@OneToMany(targetEntity = Event.class)
	private List<Event> myEvents;
	
	protected User(){}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.myEvents = new ArrayList<Event>();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Event> getMyEvents() {
		return myEvents;
	}
	public void setMyEvents(List<Event> myEvents) {
		this.myEvents = myEvents;
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
}
