package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueAjouterAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueAjouterAccreditation (VueMenuSecurite vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueAjouterAccreditation vPP = new VueAjouterAccreditation();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}