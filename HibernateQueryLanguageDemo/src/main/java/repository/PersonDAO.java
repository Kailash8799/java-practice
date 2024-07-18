package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import entities.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import utilities.HibernateUtil;

public class PersonDAO {

	public void addPerson(Person person) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(person);
		tx.commit();
		session.close();
	}

	public void selectAllPerson() {
		Session session = HibernateUtil.getSessionFactory().openSession();

//		Query<Person> query = session.createQuery("from Person", Person.class);
//		List<Person> list = query.list();
//		if (list.isEmpty())
//			System.out.println("No records found");
//		for (Person p : list) {
//			System.out.println(p);
//		}

		NativeQuery<Person> q = session.createNativeQuery("select * from person ", Person.class);
		List<Person> list1 = q.list();
		if (list1.isEmpty())
			System.out.println("No records found");
		for (Person p : list1) {
			System.out.println(p);
		}
		session.close();
	}

	public void selectPersonWhere(String where) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Person> query = session.createQuery("from Person where " + where, Person.class);
		List<Person> list = query.list();
		if (list.isEmpty())
			System.out.println("No records found");
		for (Person p : list) {
			System.out.println(p);
		}
		session.close();
	}

	public void updatePersonName(int id, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// Create a MutationQuery reference for the given HQL insert,update, or delete
		// statement.
		MutationQuery query = session.createMutationQuery("update Person set personName=:n where personId=:i");
		query.setParameter("n", name);
		query.setParameter("i", id);
		int status = query.executeUpdate();
		System.out.println(status);
		tx.commit();
		session.close();
		// this.selectAllPerson();

	}

	public void selectPersonPagination(int firstResult, int maxResults) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Person> query = session.createQuery("from Person", Person.class);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);

		List<Person> list = query.list();
		if (list.isEmpty())
			System.out.println("No records found");
		for (Person p : list) {
			System.out.println(p);
		}
		session.close();

	}

	public void deletePerson(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// Create a MutationQuery reference for the given HQL insert,update, or delete
		// statement.
		MutationQuery query = session.createMutationQuery("delete from Person where personId=:i");
		query.setParameter("i", id);
		int status = query.executeUpdate();
		System.out.println(status);
		tx.commit();
		this.selectAllPerson();
		session.close();
	}

	public void selectPersonById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Person> query = session.createQuery("from Person where personId = " + id, Person.class);

		try {
			Person p = query.getSingleResult();
			System.out.println(p);
		} catch (jakarta.persistence.NoResultException e) {
			System.out.println("No records found");
		}

	}

	public void useOfAggregateFunctions() {
		// min(), max(), sum(), avg(), and count()
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session.createQuery("SELECT min(phoneNo) from Person", Person.class).getSingleResult());
		System.out.println(session.createQuery("SELECT max(phoneNo) from Person", Person.class).getSingleResult());
		System.out.println(session.createQuery("SELECT sum(phoneNo) from Person", Person.class).getSingleResult());
		System.out.println(session.createQuery("SELECT avg(phoneNo) from Person", Person.class).getSingleResult());
		System.out.println(session.createQuery("SELECT count(phoneNo) from Person", Person.class).getSingleResult());
		System.out.println(
				session.createQuery("SELECT count(distinct phoneNo) from Person", Person.class).getSingleResult());
	}

	public void useofOrderBy() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Person> query = session.createQuery("from Person order by personName", Person.class);
		List<Person> list = query.getResultList(); // getResultList() delegates to list()
		if (list.isEmpty())
			System.out.println("No records found");
		for (Person p : list) {
			System.out.println(p);
		}

		Query<Person> query1 = session.createQuery("from Person order by personName desc", Person.class);
		List<Person> list1 = query1.getResultList(); // getResultList() delegates to list()
		if (list1.isEmpty())
			System.out.println("No records found");
		for (Person p : list1) {
			System.out.println(p);
		}

	}

	public void criteriaQueryDemo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);

		criteriaQuery.where(criteriaBuilder.greaterThan(root.get("phoneNo"), 222222222));
		Query<Person> query = session.createQuery(criteriaQuery);

		List<Person> list = query.getResultList();
		for (Person p : list) {
			System.out.println(p);
		}

	}

	public void criteriaQueryMultiConditionDemo() {
		// select person where phoneno > 222222222 and phoneno < 444444444
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);

		Predicate personRestriction = criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("phoneNo"), 222222222),
				criteriaBuilder.lessThan(root.get("phoneNo"), 444444444));

		criteriaQuery.where(personRestriction);

		Query<Person> query = session.createQuery(criteriaQuery);
		List<Person> personList = query.getResultList();
		for (Person p : personList) {
			System.out.println(p);
		}

	}
	
	public void criteriaQueryWithProjection1Demo() {
		// select name person where phoneno > 222222222 and phoneno < 444444444
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Person> root = criteriaQuery.from(Person.class);

		Predicate personRestriction = criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("phoneNo"), 222222222),
				criteriaBuilder.lessThan(root.get("phoneNo"), 444444444));

		criteriaQuery.multiselect(root.get("personName"));
		criteriaQuery.where(personRestriction);

		Query<String> query = session.createQuery(criteriaQuery);
		List<String> personList = query.getResultList();
		for (String ob : personList) {
			System.out.println(ob);
		}

		
		
	}
	public void criteriaQueryWithProjection2Demo() {
		// select name and phoneNo of person where phoneno > 222222222 and phoneno < 444444444
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Person> root = criteriaQuery.from(Person.class);

		Predicate personRestriction = criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("phoneNo"), 222222222),
				criteriaBuilder.lessThan(root.get("phoneNo"), 444444444));

		criteriaQuery.multiselect(root.get("personName"), root.get("phoneNo"));
		criteriaQuery.where(personRestriction);

		Query<Object[]> query = session.createQuery(criteriaQuery);
		List<Object[]> personList = query.getResultList();
		for (Object[] ob : personList) {
			System.out.println(ob[0] + "  " + ob[1]);
		}

	}

}
