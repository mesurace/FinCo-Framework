package framework.lib.transaction;

import java.util.ArrayList;
import java.util.List;

import framework.lib.mediator.ISenderColleague;
import framework.lib.mediator.Mediator;
import framework.lib.mediator.Message;

/**
 *
 * @author Manish Karki
 */
public class TransactionManager implements ISenderColleague {
	private List<ITransaction> transactions;
	private static final String NAME = "TRANSACTION_MANAGER";
    Mediator mediator;
	public TransactionManager(Mediator mediator) {
        transactions = new ArrayList<>();
        this.mediator = mediator;
    }

	
	public void invoke(ITransaction transaction) {
		transaction.compute();
		transactions.add(transaction);
	}
	
	public List<ITransaction> getTransactions() {
		return transactions;
	}


	@Override
	public String getName() {
		return NAME;
	}


	@Override
	public void send(Message message) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

}
