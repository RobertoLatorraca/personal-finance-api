package ar.latorraca.finance.domain.models.account;

public enum AccountType {

	BANK(BankAccount.class),
	CREDIT_CARD(BankAccount.class),
	INVESTMENT(BankAccount.class),
	SAFETY_BOX(BankAccount.class),
	CASH(BankAccount.class);

	private Class<? extends Account> clazz;

	AccountType(Class<? extends Account> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends Account> getClazz() {
		return clazz;
	}

}
