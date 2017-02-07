package com.asd.group1.framework.lib.mediator;


public interface IMediator {
	public void send(IColleague colleague, Message message);

	public void addColleague(IColleague colleague);
}
