package ca.bcit.comp2613.restaurant;

import javax.swing.table.DefaultTableModel;

public class SwingManagerModel extends DefaultTableModel 
{
	
	@Override
	public boolean isCellEditable(int row, int column)
	{
	 //all cells false
		return false;
	}
	
}
