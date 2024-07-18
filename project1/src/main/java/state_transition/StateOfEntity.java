package state_transition;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.StudentDemo;

public class StateOfEntity {
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

	private static void checkState(Session session, Object o) {
		if (session.contains(o))
			System.out.println("Object is in persistent state");
		else
			System.out.println("Object is not in persistent state");
	}

	private static void demoTransientToPersistent() {
		StudentDemo s = new StudentDemo();
		s.setId(5);
		s.setName("ABCD");
		s.setCpi(8.0);

		Session session = sessionFactory.openSession();
		System.out.println("session.isOpen() = " + session.isOpen()); // true
		session.beginTransaction();

		System.out.print("Before call to persist() : ");
		checkState(session, s); // Object is not in persistent state
		session.persist(s);
		System.out.print("After call to persist() : ");
		checkState(session, s); // Object is in persistent state

s.setCpi(8.5);
		session.getTransaction().commit(); // insert into StudentDemo (cpi, name, id) values (?, ?, ?)
											// update StudentDemo set cpi=?, name=? where id=?

s.setName("BBBB");
//	checkState(session, s); // Object is in persistent state
		// session.getTransaction().commit(); // java.lang.IllegalStateException:
		// Transaction not successfully started

	session.close(); // NOTE: End the session by releasing the JDBC connection and cleaning up.
System.out.println("session.isOpen() = " + session.isOpen()); // false

s.setCpi(40);
		checkState(session, s); // java.lang.IllegalStateException:
		// Session/EntityManager is closed
	}

	private static void demoPersistentDetached() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		StudentDemo temp_s = session.get(StudentDemo.class, 1); // select s1_0.id,s1_0.cpi,s1_0.name from StudentDemo s1_0 where
														// s1_0.id=?
		System.out.print("After call to get() : ");
		checkState(session, temp_s); // Object is in persistent state

		double cpi = temp_s.getCpi();
		temp_s.setCpi(cpi + 1);

		session.getTransaction().commit(); // update StudentDemo set cpi=?, name=? where id=?

		session.detach(temp_s);
		System.out.print("After call to detach() : ");
		checkState(session, temp_s); // Object is not in persistent state

		double cpi2 = temp_s.getCpi();
		temp_s.setCpi(10 - cpi2);

		System.out.print("Before call to merge() : ");
		checkState(session, temp_s); // Object is not in persistent state
		temp_s = session.merge(temp_s); // select s1_0.id,s1_0.cpi,s1_0.name from StudentDemo s1_0 where s1_0.id=?
		System.out.print("After call to merge() : ");
		checkState(session, temp_s); // Object is in persistent state

		session.evict(temp_s);
		System.out.print("After call to evict() : ");
		checkState(session, temp_s); // Object is not in persistent state

		session.close();

	}

	private static void demoPersistentRemoved() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		StudentDemo temp_s = session.get(StudentDemo.class, 1); // select s1_0.id,s1_0.cpi,s1_0.name from StudentDemo s1_0 where
														// s1_0.id=?
		System.out.print("After call to get() : ");
		checkState(session, temp_s); // Object is in persistent state

		session.remove(temp_s);

		String nm = temp_s.getName();
		temp_s.setName(nm + "123");
		System.out.print("After call to remove() : ");
		checkState(session, temp_s); // Object is not in persistent state

		// temp_s = session.merge(temp_s); // java.lang.IllegalArgumentException:
		// org.hibernate.ObjectDeletedException: deleted instance passed to merge:
		// [entities.StudentDemo#<null>]

		session.persist(temp_s);
		System.out.print("After call to persist() : ");
		checkState(session, temp_s); // Object is in persistent state
	}

	public static void main(String[] args) {

//		demoTransientToPersistent();

	demoPersistentDetached();
//
//		demoPersistentRemoved();
	}
}
