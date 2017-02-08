package framework.lib.factory;

import framework.app.customer.Company;
import framework.app.customer.Person;
import framework.app.type.CustomerType;
import framework.lib.customer.ICustomer;

/**
 *
 * @author Manish Karki
 */
public class CustomerFactory extends AbstractFactory {

	@SuppressWarnings("rawtypes")
	public ICustomer getCustomer(Enum type) {
		if (type == CustomerType.COMPANY) {
			return new Company();
		} else if (type == CustomerType.PERSONAL) {
			return new Person();
		}
		return null;
	}

}
