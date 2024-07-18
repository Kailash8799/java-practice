/*
 * Table Per Class Hierarchy
 *  
 */

package entities;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "BankAccount")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//This is the annotation which signifies the strategy type used for 
//inheritance relationship mapping using the strategy attribute. 
// For table per concrete class, the strategy should be InheritanceType.TABLE_PER_CLASS.

public class BankAccount {
	@Id
	private Long accountNo;
	private Calendar openingDate;
	private Double balance;
	private String accountStatus;

	public BankAccount() {
		super();
	}

	public BankAccount(Long accountNo, Calendar openingDate, Double balance, String accountStatus) {
		super();
		this.accountNo = accountNo;
		this.openingDate = openingDate;
		this.balance = balance;
		this.accountStatus = accountStatus;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
