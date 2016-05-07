package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueConsulterEvenements implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueConsulterEvenements (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueConsulterEvenements vPP = new VueConsulterEvenements();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}