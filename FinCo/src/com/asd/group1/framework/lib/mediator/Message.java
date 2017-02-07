package com.asd.group1.framework.lib.mediator;

/**
 *
 * @author Manish Karki
 */
public class Message {

	private String sub;
	private boolean status;

	public Message(String sub, boolean status) {
		this.sub = sub;
		this.status = status;
	}

	public String getsub() {
		return sub;
	}

	public boolean isStatus() {
		return status;
	}

}
