package repository;

import java.util.List;

import org.hibernate.Session;

import entities.Department;
import entities.Employee;
import utilities.HibernateUtil;

public class DepartmentDAO {
	private final Session session;

	public DepartmentDAO() {
		super();
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void addDepartment(Department dept) {
		session.getTransaction().begin();
		// you may check if there is already a department with same name
		session.persist(dept);
		session.getTransaction().commit();
	}

	public void addEmployeeToStaff(int department_id, Employee emp) {
		Department temp_dept = session.get(Department.class, department_id);
		if (temp_dept != null) {
			emp.setEmp_department(temp_dept);

			List<Employee> staff_list = temp_dept.getStaffmembers();
			staff_list.add(emp);

			session.getTransaction().begin();
			session.persist(emp);
			session.getTransaction().commit();
		}
	}

	public void showDepartment(int department_id) {
		Department temp_dept = session.get(Department.class, department_id);
		if (temp_dept != null)
			System.out.println(temp_dept);
	}

	public void updateDepartment(int department_id, String department_name) {
		Department temp_dept = session.get(Department.class, department_id);
		if (temp_dept != null) {
			temp_dept.setDepart_name(department_name);
			session.getTransaction().begin();
			session.merge(temp_dept);
			session.getTransaction().commit();
		}
	}

	public void deleteDepartment(int department_id) {
		Department temp_dept = session.get(Department.class, department_id);
		if (temp_dept != null) {
			session.getTransaction().begin();
			session.remove(temp_dept);
			session.getTransaction().commit();
		}
	}
}
