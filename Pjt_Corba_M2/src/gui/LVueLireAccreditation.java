package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueLireAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueLireAccreditation (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueLireAccreditation vPP = new VueLireAccreditation();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}