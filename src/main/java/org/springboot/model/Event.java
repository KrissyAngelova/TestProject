package org.springboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {

	@Id
	@Column(name = "event_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "event_name")
	private String name;
	
	@Column(name = "event_desc")
	private String description;
	
	@Column(name = "event_date")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	 private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = CascadeType.ALL)
	private List<Gift> wantedGifts;
	
	protected Event(){}
	
	public Event(String name, String description, Date date, User user) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.user = user;
		wantedGifts = new ArrayList<Gift>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Gift> getWantedGifts() {
		return wantedGifts;
	}
	public void setWantedGifts(List<Gift> wantedGifts) {
		this.wantedGifts = wantedGifts;
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
}
