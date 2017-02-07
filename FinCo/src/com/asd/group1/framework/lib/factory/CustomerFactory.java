package com.asd.group1.framework.lib.factory;

import com.asd.group1.framework.app.customer.Company;
import com.asd.group1.framework.app.customer.Person;
import com.asd.group1.framework.app.type.PartyType;
import com.asd.group1.framework.lib.customer.ICustomer;

/**
 *
 * @author Manish Karki
 */
public class CustomerFactory extends AbstractFactory {

	@SuppressWarnings("rawtypes")
	public ICustomer getCustomer(Enum type) {
		if (type == PartyType.COMPANY) {
			return new Company();
		} else if (type == PartyType.PERSONAL) {
			return new Person();
		}
		return null;
	}

}
