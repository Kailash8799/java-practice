package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Contact")
public class Contact {
	@Id
	private Integer id;

	private Name name;
	private boolean starred;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(Integer id, Name name, boolean starred) {
		super();
		this.id = id;
		this.name = name;
		this.starred = starred;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public boolean isStarred() {
		return starred;
	}
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	
}
