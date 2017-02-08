package com.asd.group1.creditcard;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import com.asd.group1.bank.controller.DepositController;
import com.asd.group1.bank.controller.WithdrawController;
import com.asd.group1.creditcard.account.CreditCardAccount;
import com.asd.group1.creditcard.controller.AddCreditCardController;
import com.asd.group1.creditcard.controller.BillController;
import com.asd.group1.creditcard.factory.CreditCardFactory;
import com.asd.group1.creditcard.type.CreditAccountType;
import com.asd.group1.framework.app.comparator.AccountComparator;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.components.ext.AccountEntryDataModel;
import com.asd.group1.framework.lib.account.AAccount;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ACustomer;
import com.asd.group1.framework.lib.factory.FincoFactory;
import com.asd.group1.framework.lib.mediator.Mediator;
import com.asd.group1.framework.lib.mediator.Message;
import com.asd.group1.singleton.SingletonProvider;

/**
 *
 * @author Manish Karki
 */
public class CreditCard extends AccountFrm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static {
        FincoFactory.addAbstractFactory(CreditAccountType.MYAC, new CreditCardFactory());
    }
	public static CreditCard creditCard;
	public static CreditCard getInstance() {
        if (creditCard == null) {
            creditCard = new CreditCard();
            SingletonProvider.setAccountFrm(creditCard);
        }
        return creditCard;
    }
	
	public CreditCard() {
        setTitle("Credit Card Application");

        JButton_PerAC.setText("Add Credit-card account");
        JButton_Withdraw.setText("Charge");
        JButton_CompAC.setText("Generate Monthly bills");

        //remove all listener that we have first
        for (ActionListener al : JButton_PerAC.getActionListeners()) {
            JButton_PerAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_CompAC.getActionListeners()) {
            JButton_CompAC.removeActionListener(al);
        }
        for (ActionListener al : JButton_Deposit.getActionListeners()) {
            JButton_Deposit.removeActionListener(al);
        }
        for (ActionListener al : JButton_Withdraw.getActionListeners()) {
            JButton_Withdraw.removeActionListener(al);
        }

        JButton_CompAC.addActionListener(new BillController());
        JButton_PerAC.addActionListener(new AddCreditCardController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
    }
	
	@Override
    public String getAccountNo() {
        int selection = table1.getSelectionModel().getMinSelectionIndex();
        String accnr = "0";
        try {
            accnr = (String) model.getValueAt(selection, 1);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return accnr;
    }

    @Override
    protected AccountEntryDataModel setTableModel(Mediator mediator) {
        AccountEntryDataModel model = new AccountEntryDataModel(mediator);

        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");

        return model;
    }

    @SuppressWarnings({ "unchecked", "static-access" })
	@Override
    public void loadTableWithData() {
        try {
            model.setRowCount(0);
            AccountManager accountManager = SingletonProvider.getInstanceAccountManager();
            for (Iterator<AAccount> it = accountManager.getAccounts().getSortedIterator(new AccountComparator(selectedColumn)); it.hasNext();) {
                IAccount iAccount = it.next();
                rowdata = new Object[8];
                rowdata[1] = iAccount.getAcctNumber();
                ACustomer aCustomer = (ACustomer) iAccount.getCustomer();
                rowdata[0] = aCustomer.getName();
                CreditCardAccount account = (CreditCardAccount) iAccount;
                rowdata[2] = account.getExpiryDate();
                rowdata[3] = iAccount.getType();
                rowdata[4] = iAccount.getCurrentBalance();
                model.addRow(rowdata);
            }
			model.send(new Message(accountManager.ACCOUNT_SELECTED, false));
        } catch (Exception ex) {
            Logger.getLogger(AccountFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            //(new Bank()).setVisible(true);
            CreditCard.getInstance().setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }


}

