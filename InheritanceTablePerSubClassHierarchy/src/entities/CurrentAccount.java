package entities;

import java.util.Calendar;

import jakarta.persistence.Entity;

@Entity
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
