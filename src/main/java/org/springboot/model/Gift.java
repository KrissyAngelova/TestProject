package org.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Gift {

	@Id
	@Column(name = "gift_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "gift_name")
	private String name;
	
	@Column(name = "gift_desc")
	private String description;
	
	@Column(name = "is_taken")
	private boolean isTaken;
	
	@OneToOne
	private User buyer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	 private Event event;
	
	protected Gift(){}
	
	public Gift(String name, String description,Event event, boolean isTaken, User buyer) {
		super();
		this.name = name;
		this.description = description;
		this.isTaken = isTaken;
		this.buyer = buyer;
	}
	
	public Gift(String name, String description, Event event) {
		super();
		this.name = name;
		this.description = description;
		this.event = event;
		this.isTaken = false;
		this.buyer = null;
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

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	
}
