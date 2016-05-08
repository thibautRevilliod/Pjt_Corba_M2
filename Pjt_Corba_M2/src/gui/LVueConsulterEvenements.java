package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class LVueConsulterEvenements implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueConsulterEvenements (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		JTable table = new JTable();
		VueConsulterEvenements vPP = new VueConsulterEvenements(table);
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}