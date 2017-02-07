package com.asd.group1.framework.app.functor;

import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.functor.IFunctor;

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

