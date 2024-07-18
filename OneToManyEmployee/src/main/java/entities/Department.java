package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depart_id;
	private String depart_name;
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "emp_department", cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_dept_id")
	private List<Employee> staffmembers;

	public Department() {
		super();
		this.staffmembers = new ArrayList<>();
	}

	public Department(String depart_name) {
		super();
		this.depart_name = depart_name;
		this.staffmembers = new ArrayList<>();
	}

	public int getDepart_id() {
		return depart_id;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}

	public List<Employee> getStaffmembers() {
		return staffmembers;
	}

	public void setStaff_members(List<Employee> staff_members) {
		this.staffmembers = staff_members;
	}

	@Override
	public String toString() {
		return "Department [depart_id=" + depart_id + ", depart_name=" + depart_name + ", staff_members=" + staffmembers
				+ "]";
	}
}
