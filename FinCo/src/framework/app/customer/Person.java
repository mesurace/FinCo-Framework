package framework.app.customer;

import java.util.Date;

import framework.app.predicates.NegativeBalance;
import framework.app.predicates.Person500Deposit;
import framework.lib.account.IAccount;
import framework.lib.customer.ACustomer;
import framework.lib.customer.IPerson;
import framework.lib.functor.IFunctor;
import framework.lib.predicate.IPredicate;

/**
 * @author Suresh Adhikari
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Person extends ACustomer implements IPerson {

	private Date dateOfBirth = new Date("02/07/2017");
	private final String type = "P";

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public void addAccount(IAccount account) {
		super.addAccount(account);
	}

	@Override
	public void removeAccount(IAccount account) {
		// super.removeAccount(account);
	}

	@Override
	public void sendEmail(IFunctor f, IPredicate p, double amount) {
		if (p != null) {
			if (p.check(amount)) {
				if (f != null) {
					f.compute(this);
				}
			}
		} else {
			f.compute(this);
		}
	}

	@Override
	public String getType() {
		return type;
	}

	public IPredicate getDepositPredicate() {
		return new Person500Deposit();
	}

	public IPredicate getWithdrawPredicate() {
		return new NegativeBalance();
	}

}
