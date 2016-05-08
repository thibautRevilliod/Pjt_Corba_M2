package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueChoixLireAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueChoixLireAccreditation (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueChoixLireAccreditation vPP = new VueChoixLireAccreditation();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}