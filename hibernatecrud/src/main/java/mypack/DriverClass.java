package mypack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Student;

public class DriverClass {
	/*
	 * private:
	 */
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();

		} catch (HibernateException he) {
			System.out.println("Session Factory creation failure");
			// throw he;
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) throws Exception {

		Student s = new Student();
		s.setId(1);
		s.setName("ABC");
		s.setCpi(8.0);
		createStudent(s);
		readStudent(1);

		updateStudentName(1, "AAAA");
		readStudent(1);

		updateStudentName(1, "8.5");
		readStudent(1);

		deleteStudent(1);
		readStudent(1);

	}

	public static void createStudent(Student s) {
		// CREATE OPERATION (insert query)
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(s);			
			session.getTransaction().commit();
			session.close();
		}
	}

	public static void readStudent(int id) {
		// READ OPERATION (select query)
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();			
			Student temp_s = session.get(Student.class, id);			
			session.close();
			System.out.println(temp_s);
		}
	}

	public static void updateStudentName(int id, String name) {
		// UPDATE OPERATION (update query)
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student temp_s = session.get(Student.class, id);
			temp_s.setName(name);
			session.merge(temp_s);
			session.getTransaction().commit();
			session.close();
		}
	}

	public static void updateStudentCPI(int id, double cpi) {
		// UPDATE OPERATION (update query)
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student temp_s = session.get(Student.class, id);
			temp_s.setCpi(cpi);
			session.merge(temp_s);
			session.getTransaction().commit();
			session.close();
		}
	}

	public static void deleteStudent(int id) {
		// DELETE OPERATION (delete query)
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student temp_s = session.get(Student.class, id);
			session.remove(temp_s);
			session.getTransaction().commit();
			session.close();
		}
	}
}