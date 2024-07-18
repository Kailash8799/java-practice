import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Locker;
import entities.Player;
import utilities.HibernateUtil;
@SuppressWarnings("unused")
public class MainClass {
	private static void addNewPlayerNewLocker(Player p, Locker l) {

		p.setLocker(l);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p); // saving the player and locker details
		tx.commit();
		session.close();

	}

	private static void addNewPlayerNoLocker(Player p) {
		p.setLocker(null);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p); // saving the player and null locker details
		tx.commit();
		session.close();
	}

	private static void insertDemo() throws ParseException {
//		Scanner sc = new Scanner(System.in);
//		// System.out.println("Enter the Player's Id");
//		// int id = sc.nextInt();
//		System.out.println("Enter the Player's name");
//		String name = sc.next();
//		System.out.println("Enter the Player's date of birth in MM/dd/yyyy format");
//		String datestr = sc.next();
//		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
//		Date dob = (Date) formatter.parse(datestr);
//
//		System.out.println("Enter the Player's address");
//		String address = sc.next();
//		System.out.println("Enter the Player's phoneNo");
//		long phone = sc.nextLong();
//
//		System.out.println("Do you want to allocate Locker(Y/N)");
//		String lock = sc.next();
//		if (lock.compareToIgnoreCase("y") == 0) {
//			// System.out.println("Enter the Locker Id");
//			// int lid = sc.nextInt();
//			System.out.println("Enter the locker type (regular/premium)");
//			String ltype = sc.next();
//			System.out.println("Enter the rent");
//			Double lrent = sc.nextDouble();
//
//			Locker l1 = new Locker(ltype, lrent);
//
//			Player p1 = new Player(name, dob, address, phone);
//			addNewPlayerNewLocker(p1, l1);

//		} else {
//			Player p1 = new Player(name, dob, address, phone);
//			addNewPlayerNoLocker(p1);
//		}
//		sc.close();
		addNewPlayerNewLocker(new Player("abcd", new Date(System.currentTimeMillis()), "Anand", 919900000000L),
				new Locker("premium", 5500.0));
		addNewPlayerNewLocker(new Player("xyz", new Date(System.currentTimeMillis()), "Nadiad", 919800000000L),
				new Locker("premium", 5500.0));

	}

	private static void selectPlayerDemo(int playerId) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Player p1 = session.get(Player.class, playerId); // playerId = 1
			if (p1 != null) {
				System.out.println(p1);
				System.out.println(p1.getLocker().getRent()); // fetching locker's rent using Player object
			} else {
				System.out.println("No player with id = " + playerId);
			}
		} catch (Exception e) {
		} finally {
			session.close();
		}

	}

	private static void selectLockerDemo(int lockerId) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Locker l1 = session.get(Locker.class, lockerId); // lockerId = 1
			if (l1 != null) {
				System.out.println(l1);
//				System.out.println(l1.getPlayer().getPlayerName()); // fetching player's name using locker object
//				System.out.println(l1.getPlayer().getPhoneNo()); // fetching player's phoneNo using locker object
			} else {
				System.out.println("No locker with id = " + lockerId);
			}
		} catch (Exception e) {

		} finally {
			session.close();
		}

	}

	private static void updatePlayerDemo(int player_id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Player p1 = session.get(Player.class, player_id);
			if (p1 != null) {
				p1.setPhoneNo(9998888999L);
				session.persist(p1);
				tx.commit();
			} else {
				System.out.println("No player with id = " + player_id);
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	private static void updateLockerDemo(int lockerId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Locker l1 = session.get(Locker.class, lockerId);
			if (l1 != null) {
				l1.setRent(7000.0);
				session.persist(l1);
				tx.commit();
			} else {
				System.out.println("No locker with id = " + lockerId);
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}

	
	private static void deletePlayerDemo(int playerId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Player p1 = session.get(Player.class, playerId);
			if (p1 != null) {
				session.remove(p1);
				tx.commit();
			} else {
				System.out.println("No player with id = " + playerId);
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}

	private static void deleteLockerDemo(int lockerId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Locker l1 = session.get(Locker.class, lockerId);
			if (l1 != null) {
				session.remove(l1);
				tx.commit();
				System.out.println("Deleting locker with id = " + lockerId);
			} else {
				System.out.println("No locker with id = " + lockerId);
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}


	public static void main(String[] args) throws ParseException {

		int player_id = 1;
		int locker_id = 1;

//		insertDemo();
//		selectPlayerDemo(player_id);
//		selectLockerDemo(locker_id);

//		updatePlayerDemo(player_id);
//		selectPlayerDemo(player_id);
//		selectLockerDemo(locker_id);

//		updateLockerDemo(locker_id);
//		selectPlayerDemo(player_id);
//		selectLockerDemo(locker_id);

//		deletePlayerDemo(player_id);
//		selectPlayerDemo(player_id);
//		selectLockerDemo(locker_id);

//		deleteLockerDemo(locker_id);
//		selectPlayerDemo(player_id);
//		selectLockerDemo(locker_id);

	}

}
