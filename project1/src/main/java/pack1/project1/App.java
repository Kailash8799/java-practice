package pack1.project1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();

		} catch (HibernateException he) {
			System.out.println("Session Factory creation failure");
			throw he;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    public static void main( String[] args )
    {
//    	Student s = new Student();
//		s.setId(8);   it is not required as auto incremented
//		s.setName("shital");
//		s.setCpi(9.0);
//		createStudent(s);
//		updateStudentName(1,"priyanka");
//		deleteStudent(1);
//		updateStudentCPI(52,10.0);
		readStudent(1);
     }
    public static void createStudent(Student s) {
    	Transaction tx=null;
		Session session=null;
		try
		{
		// CREATE OPERATION (insert query)
		session = sessionFactory.openSession();
		tx=session.beginTransaction();
		session.persist(s);
		tx.commit();
		
		}
		catch(Exception e)
		{
			if (tx != null) {
	            tx.rollback();
	        }
		}
		finally
		{
			session.close();
		}
	}
    public static void updateStudentName(int id, String name) {
		// UPDATE OPERATION (update query)
		Session session = sessionFactory.openSession(); // open session or create session
		session.beginTransaction(); // begin transaction returns a transaction object
		Student temp_s = session.get(Student.class, id); // get returns a persistance object or null
		
		temp_s.setName(name);
//		session.update(temp_s);//merge 
		session.merge(temp_s); // for update
		session.getTransaction().commit();
		session.close();
	}
    public static void updateStudentCPI(int id, double cpi) {
		// UPDATE OPERATION (update query)
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student temp_s = session.get(Student.class, id);
		temp_s.setCpi(cpi);
		session.merge(temp_s);//remove
	
		session.getTransaction().commit();
		session.close();
	}
    public static void readStudent(int id) {
		// READ OPERATION (select query)
		Session session = sessionFactory.openSession();
		// no need to begin transaction as we dont need to commit 
		Student temp_s = session.get(Student.class, id);
		session.close();
		System.out.println(temp_s);
	}

    public static void deleteStudent(int id) {
		// DELETE OPERATION (delete query)
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student temp_s = session.get(Student.class, id);
		session.remove(temp_s);
		session.getTransaction().commit();
		session.close();
	}


}
