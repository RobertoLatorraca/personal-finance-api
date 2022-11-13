package ar.latorraca.finance.domain.models.account;

public enum AccountType {

	BANK(BankAccount.class),
	CREDIT_CARD(CreditCardAccount.class),
	INVESTMENT(BankAccount.class),
	CASH(CashAccount.class);

	private Class<? extends Account> clazz;

	AccountType(Class<? extends Account> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends Account> getClazz() {
		return clazz;
	}

}
