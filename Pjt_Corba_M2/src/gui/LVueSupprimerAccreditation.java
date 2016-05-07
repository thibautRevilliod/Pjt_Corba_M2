package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueSupprimerAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueSupprimerAccreditation (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueSupprimerAccreditation vPP = new VueSupprimerAccreditation();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}