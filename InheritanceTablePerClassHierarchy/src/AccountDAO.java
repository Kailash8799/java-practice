
import org.hibernate.Session;

import entities.BankAccount;
import entities.CurrentAccount;
import entities.SavingsAccount;
import utilities.HibernateUtil;

public class AccountDAO   {

	public Long addAccountDetails(BankAccount account) throws Exception{
		Long accountNo = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		if (account instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount) account;
			accountNo = (Long) session.save(sa);

		} else if (account instanceof CurrentAccount) {
			CurrentAccount ca = (CurrentAccount) account;
			accountNo = (Long) session.save(ca);
		}
		session.getTransaction().commit();
                session.close();
		return accountNo;
	}

	public BankAccount getAccountDetails(Long accountNo) throws Exception {
		BankAccount account = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		BankAccount ae = session.get(BankAccount.class, accountNo);
		if (ae instanceof SavingsAccount) {
			SavingsAccount sae = (SavingsAccount) ae;
			account = sae;
		} else if (ae instanceof CurrentAccount) {
			CurrentAccount cae = (CurrentAccount) ae;
			account = cae;
		}
                session.close();
		return account;
	}
}
