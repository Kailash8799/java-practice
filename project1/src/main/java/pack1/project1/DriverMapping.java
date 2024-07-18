package pack1.project1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import mapping.Question;

public class DriverMapping {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Question q1=new Question();
////		q1.setQuestion_id(1);
//		q1.setQuestion("what is java");
//		Answer a1=new Answer();
//		a1.setAnswer_id(111);
//		a1.setAnswer("java is object oriented proramming");
//		q1.setA(a1);
//		createquestion(q1);
		readquestion(1);
	}
	 public static void createquestion(Question s) {
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
	 public static void readquestion(int id) {
			// READ OPERATION (select query)
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Question a= session.get(Question.class, id);
			session.getTransaction().commit();
			session.close();
			System.out.println(a);
		}

}
