package com.asd.group1.framework.app.predicates;

import com.asd.group1.framework.lib.predicate.IPredicate;

/**
 *
 * @author Manish Karki
 */
public class Person500Deposit implements IPredicate<Double> {

    @Override
    public boolean check(Double t) {
        return t > 500;
    }

}
