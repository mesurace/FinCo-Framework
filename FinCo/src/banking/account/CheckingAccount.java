
package banking.account;

import framework.lib.account.AAccount;
import framework.lib.customer.ICustomer;

public class CheckingAccount extends AAccount {

    public CheckingAccount() {
        super.setType("Ch");
    }

    
    
    @Override
    public String getType() {
        return "Ch";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    @Override
    public void setCustomer(ICustomer iCustomer) {
        super.setCustomer(iCustomer);
    }

    @Override
    public ICustomer getCustomer() {
        return super.getCustomer();
    }
    
//    public double getBalance() {
//        return super.getBalance();
//    }
}
