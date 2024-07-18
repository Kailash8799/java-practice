package repository;

import dao.StudentDAOImpl;
import entities.Student;

public class StudentRepositoryImpl implements StudentRepository {
	private StudentDAOImpl studentDaoImpl;

	public StudentRepositoryImpl() {
		super();
		this.studentDaoImpl = new StudentDAOImpl();
	}

	public Student get(Long id) {
		return studentDaoImpl.get(id);		
	}

	public void add(Student student) {
		studentDaoImpl.add(student);		
	}

	public void update(Student student) {
		studentDaoImpl.update(student);		
	}

	public void remove(Student student) {
		studentDaoImpl.remove(student);		
	}

	
	

}
