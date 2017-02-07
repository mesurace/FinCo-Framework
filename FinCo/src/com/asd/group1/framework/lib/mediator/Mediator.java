package com.asd.group1.framework.lib.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator implements IMediator {

	private List<IColleague> colleagueList;

	public Mediator() {
		colleagueList = new ArrayList<IColleague>();
	}

	@Override
	public void addColleague(IColleague colleague) {
		colleagueList.add(colleague);
	}

	@Override
	public void send(IColleague colleague, Message message) {
		System.out.println(colleague.getName().toUpperCase() + " : " + message.getsub().toUpperCase() + " : "
				+ message.isStatus());
		for (IColleague c : colleagueList) {
			if (c != colleagueList) {
				if (c instanceof IReceiverColleague) {
					((IReceiverColleague) c).receive(message);
				}
			}
		}
	}
}
