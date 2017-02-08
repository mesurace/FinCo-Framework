package banking.factory;

import banking.account.CheckingAccount;
import banking.account.SavingAccount;
import banking.type.MyAccountType;
import framework.lib.account.IAccount;
import framework.lib.factory.AccountFactory;

public class MyAccountFactory extends AccountFactory {

	public MyAccountFactory() {
	}

	@Override
	public IAccount getAccount(Enum type) {
		if (type == MyAccountType.CHECKING) {
			return new CheckingAccount();
		} else if (type == MyAccountType.SAVING) {
			return new SavingAccount();
		}
		return null;
	}

}
