package framework.gui.components.ext;

import framework.gui.components.finco.FincoButton;
import framework.lib.account.AccountManager;
import framework.lib.mediator.IReceiverColleague;
import framework.lib.mediator.Mediator;
import framework.lib.mediator.Message;

public class WithdrawButton extends FincoButton implements IReceiverColleague {

	private static final String NAME = "WITHDRAW_BUTTON";

	private Mediator mediator;

	public WithdrawButton(Mediator mediator) {
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