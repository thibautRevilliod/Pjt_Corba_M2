package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueChoixEvenements implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueChoixEvenements (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueChoixEvenements vPP = new VueChoixEvenements();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}