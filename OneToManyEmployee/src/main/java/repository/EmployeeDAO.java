package repository;

import org.hibernate.Session;

import entities.Employee;
import utilities.HibernateUtil;

public class EmployeeDAO {
	private final Session session;

	public EmployeeDAO() {
		super();
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void addEmployee(Employee emp) {
		session.getTransaction().begin();
		session.persist(emp);
		session.getTransaction().commit();
	}

	public void showEmployee(int employee_id) {
		Employee temp_emp = session.get(Employee.class, employee_id);
		if (temp_emp != null)
			System.out.println(temp_emp);
		else
			System.out.println("employee is not valid");
	}

	public void updateEmployeeName(int employee_id, String employee_name) {
		Employee temp_emp = session.get(Employee.class, employee_id);
		if (temp_emp != null) {
			temp_emp.setEmp_name(employee_name);
			session.getTransaction().begin();
			session.merge(temp_emp);
			session.getTransaction().commit();
		}
	}

	public void deleteEmployee(int employee_id) {
		Employee temp_emp = session.get(Employee.class, employee_id);
		if (temp_emp != null) {
			session.getTransaction().begin();
			session.remove(temp_emp);
			session.getTransaction().commit();
		}
	}
}
