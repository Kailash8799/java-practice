package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class StudentDemo {
	@Id
	private int id;
	private String name;
	private double cpi;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCpi() {
		return cpi;
	}


	public void setCpi(double cpi) {
		this.cpi = cpi;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cpi=" + cpi + "]";
	}
}
