package com.asd.group1.framework.gui.components.ext;

import javax.swing.table.DefaultTableModel;

import com.asd.group1.framework.gui.components.finco.FincoEntryDataModel;
import com.asd.group1.framework.lib.mediator.ISenderColleague;
import com.asd.group1.framework.lib.mediator.Mediator;
import com.asd.group1.framework.lib.mediator.Message;


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
