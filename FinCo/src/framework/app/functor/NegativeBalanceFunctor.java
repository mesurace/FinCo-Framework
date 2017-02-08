package framework.app.functor;

import framework.lib.customer.ICustomer;
import framework.lib.functor.IFunctor;

/**
 *
 * @author Manish Karki
 */
public class NegativeBalanceFunctor implements IFunctor<ICustomer> {

	@Override
    public void compute(ICustomer c) {
        System.out.println("Email: Your new balance is" + c.getBalance());
    }
}

