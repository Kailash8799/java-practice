package pack1.project1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Contact;
import entities.Name;

public class DriverContact {
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
		
	Contact c=new Contact();
	c.setId(1);
	c.setStarred(true);
	Name n=new Name();
	n.setFirstName("Shital");
	n.setLastName("D.");
	n.setMiddleName("Pathar");
	c.setName(n);	
	}
	 public static void save(Contact s) {
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

}
