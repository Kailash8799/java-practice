package entities;

import java.util.Calendar;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CurrentAccount")
//@DiscriminatorValue: The string value in this annotation indicates the discriminator value 
//that the instance of the class will have when it is getting persisted into the database.
//In the absence of this annotation, the class name itself will act as the discriminator value during persist.
public class CurrentAccount extends BankAccount {
	private Double overDraftLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(Long accountNo, Calendar openingDate, Double balance, String accountStatus, Double overDraftLimit) {
		super(accountNo, openingDate, balance, accountStatus);
		this.overDraftLimit=overDraftLimit;
	}

	public Double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(Double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

}
