package framework.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manish Karki
 */
public interface Controller extends ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae);

}
