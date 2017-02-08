
package banking.account;

import framework.lib.account.AAccount;
import framework.lib.customer.ICustomer;

public class SavingAccount extends AAccount {

	public SavingAccount() {
		super.setType("S");
	}

	@Override
	public String getType() {
		return "S";
	}

	@Override
	public double getInterestAmount() {
		return 5;
	}

	@Override
    public void setCustomer(ICustomer iCustomer) {
        super.setCustomer(iCustomer);
    }

    @Override
    public ICustomer getCustomer() {
        return super.getCustomer();
    }

	public double getBalance() {
		return super.getBalance();
	}
}
