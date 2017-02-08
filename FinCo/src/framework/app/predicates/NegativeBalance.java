
package framework.app.predicates;

import framework.lib.predicate.IPredicate;

/**
 *
 * @author Manish Karki
 */
public class NegativeBalance implements IPredicate<Double> {

    @Override
    public boolean check(Double t) {
        return t < 0;
    }
}
