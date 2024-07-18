package dao;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentDAOImpl implements StudentDAO {
	private final EntityManager entityManager;

	public StudentDAOImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.hibernate.studentdetails");
		entityManager = emf.createEntityManager();
	}

	public Student get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Student student) {
		// TODO Auto-generated method stub
		
	}

}
