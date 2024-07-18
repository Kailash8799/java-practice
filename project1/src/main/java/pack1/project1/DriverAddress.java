package pack1.project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.BlobProxy;

import entities.Address;

public class DriverAddress {
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Address ob=new Address();
		ob.setStreet("college road");
		ob.setCity("nadiad");
		ob.setOpen(true);
		ob.setAddedDate(new Date());
		ob.setX(15.2);
		
		// reading image
		FileInputStream fis=new FileInputStream("src/main/java/download.png");
		byte []b=new byte[fis.available()];
		fis.read(b);
		ob.setImage(BlobProxy.generateProxy(b));
		save(ob);
		retrieveimage(1);
		fis.close();
	}

	 public static void save(Address s) {
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
	 public static void retrieveimage(int id)
	 {
		 Session session = sessionFactory.openSession();
			session.beginTransaction();
			Address temp_s = session.get(Address.class, id);
			session.getTransaction().commit();
			session.close();
			System.out.println(temp_s);
	 }
}
