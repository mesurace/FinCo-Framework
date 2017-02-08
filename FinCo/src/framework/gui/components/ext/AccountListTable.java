package framework.gui.components.ext;

import javax.swing.table.TableModel;

import framework.gui.components.finco.FincoTable;
import framework.lib.account.AccountManager;
import framework.lib.mediator.IReceiverColleague;
import framework.lib.mediator.Message;
import singleton.SingletonProvider;


public class AccountListTable extends FincoTable implements IReceiverColleague {

    private static final String NAME = "ACCOUNT_LIST_TABLE";

    public AccountListTable(TableModel dm) {
        super(dm);
    }

    @Override
    public void receive(Message message) {
        if (message.getsub().equalsIgnoreCase(AccountManager.UPDATE_ACCOUNT_TABLE)) {
            SingletonProvider.getInstanceAccountFrm().loadTableWithData();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
