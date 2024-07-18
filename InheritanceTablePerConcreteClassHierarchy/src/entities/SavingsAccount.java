package entities;

import java.util.Calendar;

import jakarta.persistence.Entity;

@Entity

public class SavingsAccount extends BankAccount {
	private Double minimumBalance;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Long accountNo, Calendar openingDate, Double balance, String accountStatus,
			Double minimumBalance) {
		super(accountNo, openingDate, balance, accountStatus);
		this.minimumBalance = minimumBalance;
	}

	public Double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

}
