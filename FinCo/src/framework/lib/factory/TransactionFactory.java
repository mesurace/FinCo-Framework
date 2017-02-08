package framework.lib.factory;

import framework.app.type.TransactionType;
import framework.lib.transaction.Deposit;
import framework.lib.transaction.ITransaction;
import framework.lib.transaction.Withdraw;

/**
 *
 * @author Manish Karki
 */
public class TransactionFactory extends AbstractFactory{

	@SuppressWarnings("rawtypes")
	public ITransaction getTransaction(Enum type){
		if (type == TransactionType.DEPOSIT) {
            return new Deposit();
        } else if (type == TransactionType.WITHDRAW) {
            return new Withdraw();
        }
        return null;
	}
}

