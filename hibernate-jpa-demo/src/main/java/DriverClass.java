import entities.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;


public class DriverClass {

	public static void main(String[] args) {

		Student s = new Student("AAAA", 10.0);

		StudentRepository rs = new StudentRepositoryImpl();
		rs.add(s);
			
	}

}
