/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group1.bank.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.bank.dialog.CompanyDialog;
import com.asd.group1.bank.type.MyAccountType;
import com.asd.group1.framework.app.customer.Company;
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


public class AddCompanyController extends AccountController{

    public AddCompanyController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm=SingletonProvider.getInstanceAccountFrm();
        CompanyDialog pac = new CompanyDialog(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }
    
    public void createAccount(MyAccountType accountType,String name,String ct,String st,String str,String zip
            ,String acnr,String noe,String em){
        IAccount account=((AccountFactory)FincoFactory.getFactory(MyAccountType.MYAC)).getAccount(accountType);
        AAccount aAccount = (AAccount)account;
        aAccount.setAcctNumber(acnr);
        
        account = aAccount;
        ICustomer customer=((CustomerFactory)FincoFactory.getFactory(Types.CUSTOMER)).getCustomer(PartyType.COMPANY);
        Company c=(Company)customer;
        c.setName(name);
        c.setCity(ct);
        c.setState(st);
        c.setStreet(str);
        c.setZip(zip);
        try{
            c.setNoOfEmployee(Integer.parseInt(noe));
        }catch(NumberFormatException e){
            System.err.println("Number formate in noofemplyee");
            c.setNoOfEmployee(1);
        }
        c.setEmail(em);
        customer=c;
        customer.addAccount(account);
        SingletonProvider.getInstanceAccountManager().addAccountToList(account);
    }
    
    
}
