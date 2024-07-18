package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="student_details")
public class Student {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double cpi;


	public Student() {
		super();
	}


	public Student(String name, double cpi) {
		super();	
		this.name = name;
		this.cpi = cpi;
	}


	public long getId() {
		return id;
	}


//	public void setId(int id) {
//		this.id = id;
//	}


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


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cpi=" + cpi + "]";
	}



}
