/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group1.bank.controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import com.asd.group1.bank.dialog.PersonDialog;
import com.asd.group1.bank.type.MyAccountType;
import com.asd.group1.framework.app.customer.Person;
import com.asd.group1.framework.app.type.PartyType;
import com.asd.group1.framework.app.type.Types;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.controller.AccountController;
import com.asd.group1.framework.lib.account.AAccount;
import com.asd.group1.framework.lib.account.IAccount;
import com.asd.group1.framework.lib.customer.ICustomer;
import com.asd.group1.framework.lib.factory.AccountFactory;
import com.asd.group1.framework.lib.factory.CustomerFactory;
import com.asd.group1.framework.lib.factory.FincoFactory;
import com.asd.group1.singleton.SingletonProvider;


public class AddPersonController extends AccountController {

    public AddPersonController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        PersonDialog pac = new PersonDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    public void createAccount(MyAccountType accountType, String name, String ct, String st, String str, String zip, String acnr, String bd, String em) {
        
        
        IAccount account=((AccountFactory)FincoFactory.getFactory(MyAccountType.MYAC)).getAccount(accountType);
    	ICustomer customer=((CustomerFactory)FincoFactory.getFactory(Types.CUSTOMER)).getCustomer(PartyType.PERSONAL);
        AAccount aAccount = (AAccount) account;
        aAccount.setAcctNumber(acnr);

        account = aAccount;

        Person c = (Person) customer;
        c.setName(name);
        c.setCity(ct);
        c.setState(st);
        c.setStreet(str);
        c.setZip(zip);
        try{
            c.setDateOfBirth(new Date(bd));
        }catch(IllegalArgumentException e){
            System.err.println("IllegalArgumentException in setDateOfBirth");
        }
        c.setEmail(em);
        customer = c;
        customer.addAccount(account);
        SingletonProvider.getInstanceAccountManager().addAccountToList(account);

    }
}
