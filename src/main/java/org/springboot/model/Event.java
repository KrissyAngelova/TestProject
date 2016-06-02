package org.springboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(targetEntity = Gift.class)
	private List<Gift> wantedGifts;
	
	protected Event(){}
	
	public Event(String name, String description, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
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
