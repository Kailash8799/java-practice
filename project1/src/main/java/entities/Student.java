package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity// Used for declaring any POJO class as an entity for a database
//@Entity(name="student_details") // to give specific name to entity
//@Table(name="student_details")
//used to change table details, some of the attributes are-
// attributes-
//1.name – override the table name
//2.catalog -to define the catalog
//3.unique-enforce unique constraints
public class Student {
	
	@Id		//Used for declaring a primary key inside our POJO class
	@GeneratedValue // for auto increment
	private int id; // by default all the attributes will be consider as a column names
	//	by default hibernate will create all columns as per the instance variable
//	@Column(name="student_name",unique=true,nullable=true) 
//	@Column(name="student_name")
	private String name;   
	private double cpi;
	@Transient  
	// if we dont want a specific member in table 
	private String Address;
	
	public int getId() {
		return id;
	}
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
