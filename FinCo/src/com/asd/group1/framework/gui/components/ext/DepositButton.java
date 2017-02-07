package com.asd.group1.framework.gui.components.ext;

import com.asd.group1.framework.gui.components.asd.ASDButton;
import com.asd.group1.framework.lib.account.AccountManager;
import com.asd.group1.framework.lib.mediator.IReceiverColleague;
import com.asd.group1.framework.lib.mediator.Mediator;
import com.asd.group1.framework.lib.mediator.Message;

public class DepositButton extends ASDButton implements IReceiverColleague {

    private static final String NAME = "DEPOSIT_BUTTON";

    private Mediator mediator;

    public DepositButton(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receive(Message message) {
        if (message.getsub().equalsIgnoreCase(AccountManager.ACCOUNT_SELECTED)) {
            this.setEnabled(message.isStatus());
        }
    }

    public static String getNAME() {
        return NAME;
    }

}
