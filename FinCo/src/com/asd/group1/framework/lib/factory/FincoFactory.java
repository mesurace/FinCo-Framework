package com.asd.group1.framework.lib.factory;

import java.util.HashMap;
import java.util.Map;

import com.asd.group1.framework.app.type.Types;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings("rawtypes")
public class FincoFactory {

	public static Map<Enum, AbstractFactory> hashMap = new HashMap<>();

    static {
        hashMap.put(Types.CUSTOMER, new CustomerFactory());
        hashMap.put(Types.ACCOUNT, new AccountFactory());
        hashMap.put(Types.TRANSACTION, new TransactionFactory());
    }

    public FincoFactory() {

    }

    public static AbstractFactory getFactory(Enum type) {
        return hashMap.get(type);
    }

    public static void addAbstractFactory(Enum e, AbstractFactory factory) {
        hashMap.put(e, factory);
    }
}

