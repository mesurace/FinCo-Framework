package com.asd.group1.framework.gui.components.asd;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ASDTable extends JTable {

	public ASDTable(TableModel dm) {
		super(dm);
		setModel(dm);
	}
}