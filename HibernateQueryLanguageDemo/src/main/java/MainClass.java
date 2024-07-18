import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;

import entities.Person;
import repository.PersonDAO;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("0. Add Few Person objects ");
		System.out.println("1. Add New Person object ");
		System.out.println("2. select * from person");
		System.out.println("3. select * from person where "); // e.g. `personName` = 'abc'
																// phoneNo > 222222222
																// phoneNo IS NULL
		System.out.println("4. update Person's name");
		System.out.println("5. select with pagination");
		System.out.println("6. delete person object");
		System.out.println("7. select person object from id");
		
		System.out.println("8. use of aggregate functions"); // min(), max(), sum(), avg(), and count() 
		System.out.println("9. use of order by");
		
		System.out.println("10. use CriteriaQuery to select with single condition");
		System.out.println("11. use CriteriaQuery to select with multi condition");
		System.out.println("12. use CriteriaQuery to select with multi condition and single projection");
		System.out.println("13. use CriteriaQuery to select with multi condition and multiple projection");
		
		System.out.println("Choose one option");
		int opt = sc.nextInt();
		switch (opt) {
		case 0:
			addFewPersons();
			break;
		case 1:
			addPerson(sc);
			break;
		case 2:
			selectAllPerson();
			break;
		case 3:
			selectPersonWhere(sc);
			break;
		case 4:
			updatePersonName(sc);
			break;
		case 5:
			selectPersonPagination(sc);
			break;
		case 6:
			deletePerson(sc);
			break;
		case 7:
			selectPersonById(sc);
			break;
		case 8:
			useOfAggregateFunctions();
			break;
		case 9:
			useofOrderBy();
			break;
		case 10:
			criteriaQueryDemo();
			break;
		case 11:
			criteriaQueryMultiConditionDemo();
			break;
		case 12:
			criteriaQueryWithProjection1Demo();
			break;	
		case 13:
			criteriaQueryWithProjection2Demo();
			break;
			
		default:
			System.out.println("Choose correct option");
		}

	}	

	private static void addFewPersons() {

		PersonDAO persondao = new PersonDAO();
		try {
			String[] names = { "abc", "pqr", "xyz", "def", "abc", "pqr", "xyz", "def", "pqr", "xyz" };
			long[] phoneno = { 111111111, 222222222, 333333333, 333333333, 444444444, 111111111, 222222222, 333333333,
					333333333, 444444444 };
			for (int i = 0; i < 10; i++) {
				Person person = new Person();
				person.setPersonName(names[i]);
				person.setDateOfBirth(new Date());
				person.setPhoneNo(phoneno[i]);
				persondao.addPerson(person);
				System.out.println("One record created");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.print(e);
		}

	}

	private static void addPerson(Scanner sc) {
		PersonDAO persondao = new PersonDAO();
		try {
			System.out.println("Enter the Person's details");
			System.out.println("Enter the Person's name");
			String name = sc.next();
			System.out.println("Enter the Person's date of birth in MM/dd/yyyy format");
			String datestr = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
			Date dob = formatter.parse(datestr);

			System.out.println("Enter the Person's phoneNo");
			long phone = sc.nextLong();

			Person person = new Person();
			person.setPersonName(name);
			person.setDateOfBirth(dob);
			person.setPhoneNo(phone);
			persondao.addPerson(person);
			System.out.println("One record created");
			sc.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	private static void selectAllPerson() {
		PersonDAO persondao = new PersonDAO();
		persondao.selectAllPerson();
	}

	private static void selectPersonWhere(Scanner sc) {
		System.out.println("Enter the where clause...");
		sc.nextLine();
		String where = sc.nextLine();
		PersonDAO persondao = new PersonDAO();
		persondao.selectPersonWhere(where);
	}

	private static void updatePersonName(Scanner sc) {
		PersonDAO persondao = new PersonDAO();
		System.out.println("Enter the Person's id");
		int id = sc.nextInt();
		System.out.println("Enter the Person's name");
		String name = sc.next();
		persondao.updatePersonName(id, name);
		System.out.println("One record updated");
		persondao.selectAllPerson();
		sc.close();

	}

	private static void selectPersonPagination(Scanner sc) {
		PersonDAO persondao = new PersonDAO();
		System.out.println("Enter firstResult : ");
		int firstResult = sc.nextInt();
		System.out.println("Enter maxResult : ");
		int maxResults = sc.nextInt();
		persondao.selectPersonPagination(firstResult, maxResults);

	}

	private static void deletePerson(Scanner sc) {
		PersonDAO persondao = new PersonDAO();
		System.out.println("Enter personId : ");
		int id = sc.nextInt();
		persondao.deletePerson(id);
		persondao.selectAllPerson();
	}
	
	private static void selectPersonById(Scanner sc) {
		PersonDAO persondao = new PersonDAO();
		System.out.println("Enter personId : ");
		int id = sc.nextInt();
		persondao.selectPersonById(id);
	}
	
	private static void useOfAggregateFunctions() {
		PersonDAO persondao = new PersonDAO();
		persondao.useOfAggregateFunctions();
	}
	
	private static void useofOrderBy() {
		PersonDAO persondao = new PersonDAO();
		persondao.useofOrderBy();
		
	}
	
	
	private static void criteriaQueryDemo() {
		PersonDAO persondao = new PersonDAO();
		persondao.criteriaQueryDemo();
		
	}
	
	private static void criteriaQueryMultiConditionDemo() {
		PersonDAO persondao = new PersonDAO();
		persondao.criteriaQueryMultiConditionDemo();
		
	}
	
	
	private static void criteriaQueryWithProjection1Demo() {
		PersonDAO persondao = new PersonDAO();
		persondao.criteriaQueryWithProjection1Demo();
		
	}

	private static void criteriaQueryWithProjection2Demo() {
		PersonDAO persondao = new PersonDAO();
		persondao.criteriaQueryWithProjection2Demo();
		
	}

	
}
