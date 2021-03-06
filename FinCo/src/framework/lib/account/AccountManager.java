package framework.lib.account;

import java.util.Iterator;

import framework.app.type.TransactionType;
import framework.app.type.Types;
import framework.lib.FincoArrayList;
import framework.lib.customer.ICustomer;
import framework.lib.factory.FincoFactory;
import framework.lib.factory.TransactionFactory;
import framework.lib.functor.IFunctor;
import framework.lib.mediator.ISenderColleague;
import framework.lib.mediator.Mediator;
import framework.lib.mediator.Message;
import framework.lib.predicate.IPredicate;
import framework.lib.transaction.Deposit;
import framework.lib.transaction.ITransaction;
import framework.lib.transaction.TransactionManager;
import singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings("unchecked")
public class AccountManager implements ISenderColleague {

	public static final String UPDATE_ACCOUNT_TABLE = "UPDATE_ACCOUNT_TABLE";
	public static final String ACCOUNT_SELECTED = "ACCOUNT_SELECTED";
    public static final String ACCOUNT_LIST_NOT_EMPTY = "ACCOUNT_LIST_NOT_EMPTY";
    private static final String NAME = "ACCOUNT_MANAGER";
    
	private TransactionManager transactionManager = null;
	private Mediator mediator;
	private FincoArrayList<AAccount> accounts;

	public AccountManager(Mediator mediator) {
		transactionManager = SingletonProvider.getInstanceTransactionManager();
		accounts = new FincoArrayList<>();
		this.mediator = mediator;
		this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, false));
		this.send(new Message(ACCOUNT_SELECTED, false));
	}

	public void removeAccount(IAccount account) {
		this.getAccounts().remove(account);
        this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, this.getAccounts().size() > 0));
        this.updateAccountTable();
	}
	
	public void addAccountToList(IAccount account) {
        this.accounts.add(account);
        this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, true));
        this.updateAccountTable();
    }
	
	public FincoArrayList<AAccount> getAccounts() {
        return accounts;
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

		account.getCustomer().sendEmail(f, p, account.getCurrentBalance());
		this.updateAccountTable();

	}

	public void updateAccountTable() {
		this.send(new Message(UPDATE_ACCOUNT_TABLE, true));
	}

	@Override
	public void send(Message message) {
		mediator.send(this, new Message(message.getsub(), message.isStatus()));

	}

	public IAccount getAccountById(String accrno) {
		for (Iterator<IAccount> it = accounts.iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            if (iAccount.getAcctNumber().equalsIgnoreCase(accrno)) {
                return iAccount;
            }
        }
        return null;
	}

	public void deposit(IAccount account, ITransaction iTransaction) {
		performTransaction(account, iTransaction);
	}

	public void Withdraw(IAccount account, ITransaction transaction) {
		performTransaction(account, transaction);
	}

	/*
	 * Pass transaction to command to execute. This will perform transaction by
	 * command pattern
	 */
	public void performTransaction(IAccount account, ITransaction transaction) {
		transaction.setupTransaction(this, account);
		transactionManager.invoke(transaction);
	}

	public void addInterest() {
		for (Iterator<AAccount> it = accounts.iterator(); it.hasNext();) {
            AAccount account = it.next();
            double interestAmount = account.getInterestAmount();
            ITransaction deposit = ( (TransactionFactory)FincoFactory.getFactory(Types.TRANSACTION)).getTransaction(TransactionType.DEPOSIT);
            deposit.setupTransaction(this, account);
            deposit.setName(Deposit.DEPOSIT_INTEREST);
            deposit.setAmount(interestAmount);
            transactionManager.invoke(deposit);
        }
        this.updateAccountTable();
	}

	@Override
	public String getName() {
		return NAME;
	}

	public StringBuilder generateReport() {
		StringBuilder sb = new StringBuilder();
        for (Iterator<IAccount> it = accounts.iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            sb.append("\n" + iAccount.generateReport().toString());
        }
        return sb;
	}

}
