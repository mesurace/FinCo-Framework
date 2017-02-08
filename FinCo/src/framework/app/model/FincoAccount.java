package framework.app.model;

import framework.lib.account.AAccount;
import framework.lib.customer.ICustomer;

/**
 *
 * @author Manish Karki
 */
public class FincoAccount extends AAccount {

    public static final String TYPE = "D";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public double getInterestAmount() {
        return 0;
    }

    @Override
    public void setCustomer(ICustomer iCustomer) {
        super.setCustomer(iCustomer);
    }

    @Override
    public ICustomer getCustomer() {
        return super.getCustomer();
    }

}

