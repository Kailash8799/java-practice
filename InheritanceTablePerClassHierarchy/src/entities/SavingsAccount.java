package entities;

import java.util.Calendar;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SavingsAccount")
//@DiscriminatorValue: The string value in this annotation indicates the discriminator value 
//that the instance of the class will have when it is getting persisted into the database.
//In the absence of this annotation, the class name itself will act as the discriminator value during persist.
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
