package com.asd.group1.framework.gui.controller;


import java.awt.event.ActionEvent;

/**
 *
 * @author Manish Karki
 */
public class ExitController implements Controller {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

}
