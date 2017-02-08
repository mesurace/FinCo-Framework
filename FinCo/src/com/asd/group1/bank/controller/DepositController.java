/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group1.bank.controller;

import java.awt.event.ActionEvent;

import com.asd.group1.bank.dialog.DepositDialog;
import com.asd.group1.framework.gui.AccountFrm;
import com.asd.group1.framework.gui.JDialog_Dialogview;
import com.asd.group1.singleton.SingletonProvider;


public class DepositController extends com.asd.group1.framework.gui.controller.DepositController {

    public DepositController() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = SingletonProvider.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new DepositDialog(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }

}
