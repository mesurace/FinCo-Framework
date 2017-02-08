package framework.app.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import framework.lib.account.AAccount;

/**
 *
 * @author Manish Karki
 */
public class AccountComparator implements Comparator<AAccount> {

	String fieldName;
	String methodName;

	public AccountComparator(String fieldName) throws Exception {
		this.fieldName = fieldName;
		this.methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	@Override
	public int compare(AAccount o1, AAccount o2) {
		String val1, val2;
		try {
			try {
				val1 = o1.getClass().getMethod(methodName, null).invoke(o1).toString();
				val2 = o1.getClass().getMethod(methodName, null).invoke(o2).toString();
				return (val1.compareTo(val2));
			} catch (IllegalAccessException ex) {
				Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalArgumentException ex) {
				Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InvocationTargetException ex) {
				Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (NoSuchMethodException ex) {
			Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SecurityException ex) {
			Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

}
