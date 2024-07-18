import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;

import entities.CurrentAccount;
import entities.SavingsAccount;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. New Current Account");
		System.out.println("2. New Savings Account");
		System.out.println("3. Retrieve Current Account");
		System.out.println("4. Retrieve Savings Account");
		System.out.println("Choose one option");
		int opt = sc.nextInt();
		switch (opt) {
		case 1:
			addCurrentAccountDetails(sc);
			break;
		case 2:
			addSavingsAccountDetails(sc);
			break;
		case 3:
			getCurrentAccountDetails();
			break;
		case 4:
			getSavingsAccountDetails();
			break;
		default:
			System.out.println("Choose correct option");
		}

	}

	public static void addCurrentAccountDetails(Scanner sc) {
		try {
			AccountDAO dao = new AccountDAO();
			System.out.println("Enter the Current account details");

			System.out.println("Enter the Account No");
			Long accno = sc.nextLong();
			System.out.println("Enter the Opening date in MM/dd/yyyy format");
			String date = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
			Date date1 = (Date) formatter.parse(date);
			Calendar openingDate = Calendar.getInstance();
			openingDate.setTime(date1);
			System.out.println("Enter the balance");
			Double balance = sc.nextDouble();
			System.out.println("Enter the Account status");
			String accountStatus = sc.next();
			System.out.println("Enter the Over Draft Amount");
			Double draftAmount = sc.nextDouble();
			CurrentAccount ca = new CurrentAccount(accno, openingDate, balance, accountStatus, draftAmount);
			dao.addAccountDetails(ca);
			System.out.println("Current account details successfully added");
			sc.close();
		} catch (HibernateException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public static void addSavingsAccountDetails(Scanner sc) {
		try {
			AccountDAO dao = new AccountDAO();
			System.out.println("Enter the Savings account details");

			System.out.println("Enter the Account No");
			Long accno = sc.nextLong();
			System.out.println("Enter the Opening date in MM/dd/yyyy format");
			String date = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
			Date date1 = (Date) formatter.parse(date);
			Calendar openingDate = Calendar.getInstance();
			openingDate.setTime(date1);
			System.out.println("Enter the balance");
			Double balance = sc.nextDouble();
			System.out.println("Enter the Account status");
			String accountStatus = sc.next();
			System.out.println("Enter the minimum balance");
			Double minBalance = sc.nextDouble();
			SavingsAccount sa = new SavingsAccount(accno, openingDate, balance, accountStatus, minBalance);
			dao.addAccountDetails(sa);
			System.out.println("Savings account details successfully added");
			sc.close();
		} catch (HibernateException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public static void getCurrentAccountDetails() {
		AccountDAO dao = new AccountDAO();
		try {
			CurrentAccount ca = (CurrentAccount) dao.getAccountDetails(559412123438L);
			if (ca != null) {
				System.out.println("Current Account Details");
				System.out.println("========================");
				System.out.println("Account NUmber: " + ca.getAccountNo());
				System.out.println("Opening Date  : " + ca.getOpeningDate().getTime());
				System.out.println("Account Status: " + ca.getAccountStatus());
				System.out.println("Available Bal.: " + ca.getBalance());
				System.out.println("Overdraft Lim.: " + ca.getOverDraftLimit());
			} else {
				System.out.println("ACCOUNT NOT FOUND");
			}
		} catch (HibernateException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public static void getSavingsAccountDetails() {
		AccountDAO dao = new AccountDAO();
		try {
			SavingsAccount sa = (SavingsAccount) dao.getAccountDetails(559412344321L);
			if (sa != null) {
				System.out.println("Savings Account Details");
				System.out.println("========================");
				System.out.println("Account NUmber: " + sa.getAccountNo());
				System.out.println("Opening Date  : " + sa.getOpeningDate().getTime());
				System.out.println("Account Status: " + sa.getAccountStatus());
				System.out.println("Available Bal.: " + sa.getBalance());
				System.out.println("Minimum Bal.  : " + sa.getMinimumBalance());
			} else {
				System.out.println("ACCOUNT NOT FOUND");
			}
		} catch (HibernateException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
