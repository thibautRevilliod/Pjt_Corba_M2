package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class LVueLireAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueLireAccreditation (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		JTable ttable = new JTable();
		VueLireAccreditation vPP = new VueLireAccreditation(ttable);
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}