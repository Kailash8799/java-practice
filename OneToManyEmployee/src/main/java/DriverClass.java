import entities.Department;
import entities.Employee;
import repository.DepartmentDAO;
import repository.EmployeeDAO;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDAO d_dao = new DepartmentDAO();
		EmployeeDAO e_dao = new EmployeeDAO();

		// CREATE/INSERT OPERATION
		d_dao.addDepartment(new Department("CSE"));
		d_dao.addDepartment(new Department("EC"));

		d_dao.addEmployeeToStaff(1, new Employee("ABCD", 50000.0));
		d_dao.addEmployeeToStaff(2, new Employee("XYZ", 55000.0));
		d_dao.addEmployeeToStaff(1, new Employee("ABC", 70000.0));
		d_dao.addEmployeeToStaff(2, new Employee("PQR", 45000.0));

		// READ/SELECT OPERATION
		d_dao.showDepartment(1);
		d_dao.showDepartment(2);

		e_dao.showEmployee(1);
		e_dao.showEmployee(2);
		e_dao.showEmployee(3);
		e_dao.showEmployee(4);

		// UPDATE OPERATION
		d_dao.updateDepartment(1, "Computer Engineering");
		d_dao.showDepartment(1);

		e_dao.showEmployee(1);

		new EmployeeDAO().showEmployee(1);

		e_dao.updateEmployeeName(1, "abcdef");
		new EmployeeDAO().showEmployee(1);

		// DELETE OPERATION
		new DepartmentDAO().deleteDepartment(2);
		new EmployeeDAO().showEmployee(2);
		//new EmployeeDAO().deleteEmployee(3);
		new DepartmentDAO().showDepartment(1);

	}

}
