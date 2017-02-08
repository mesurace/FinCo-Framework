package framework.gui.components.ext;

import javax.swing.table.DefaultTableModel;

import framework.gui.components.finco.FincoEntryDataModel;
import framework.lib.mediator.ISenderColleague;
import framework.lib.mediator.Mediator;
import framework.lib.mediator.Message;


public class AccountEntryDataModel extends FincoEntryDataModel implements ISenderColleague {

    private static final String NAME = "ACCOUNT_ENTRY_ROW";
    private Mediator mediator;

    public AccountEntryDataModel(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(Message message) {
        mediator.send(this, message);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
