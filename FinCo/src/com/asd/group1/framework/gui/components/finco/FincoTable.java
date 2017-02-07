package com.asd.group1.framework.gui.components.finco;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class FincoTable extends JTable {

	public FincoTable(TableModel dm) {
		super(dm);
		setModel(dm);
	}
}