package framework.app.predicates;

import framework.lib.predicate.IPredicate;

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
