package com.asd.group1.framework.lib.account;

import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;
import com.asd.group1.framework.lib.mediator.Message;
import com.asd.group1.framework.lib.predicate.IPredicate;
import com.asd.group1.framework.lib.transaction.Deposit;
import com.asd.group1.framework.lib.transaction.ITransaction;

/**
 *
 * @author Manish Karki
 */
public class AccountManager {
	 
	private static final String UPDATE_ACCOUNT_TABLE = "UPDATE_ACCOUNT_TABLE";

	public void removeAccount(IAccount account){
		 
	 }

	public void addAccountTransaction(IAccount account, ITransaction transaction) {
		account.addTransaction(transaction);
		account.updateAmountByTransaction(transaction);
		
		IPredicate<Double> p;
        IFunctor<ICustomer> f;

        if (transaction instanceof Deposit) {
            p = account.getCustomer().getDepositPredicate();
            f = transaction.getFunctor();
        } else {
            p = account.getCustomer().getWithdrawPredicate();
            f = transaction.getFunctor();
        }

	}
	
	public void updateAccountTable() {
        this.send(new Message(UPDATE_ACCOUNT_TABLE, true));
    }

	private void send(Message message) {
		// TODO Auto-generated method stub
		
	}
}

