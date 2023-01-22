package ar.latorraca.finance.domain.models.account;

import lombok.Getter;

@Getter
public enum AccountType {

	BANK(BankAccount.class, "Bank", "fa-solid"),
	CREDIT_CARD(CreditCardAccount.class, "Credit Card", "fa-solid"),
	INVESTMENT(BankAccount.class, "Investment", "fa-solid"),
	CASH(CashAccount.class, "Cash", "fa-solid");

	private Class<? extends Account> clazz;
	private String title;
	private String fontawesome;

	AccountType(Class<? extends Account> clazz, String title, String fontawesome) {
		this.clazz = clazz;
		this.title = title;
		this.fontawesome = fontawesome;
	}
/*
	public Class<? extends Account> getClazz() {
		return clazz;
	}
*/
}
