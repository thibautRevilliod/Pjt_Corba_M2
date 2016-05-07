package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueAjouterEmpreinte implements ActionListener
{

	private VueMenuRH vm;

	public LVueAjouterEmpreinte (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueAjouterEmpreinte vPP = new VueAjouterEmpreinte();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}