package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueCorrespondanceEmpreinteIdentifiant implements ActionListener
{

	private VueMenuRH vm;

	public LVueCorrespondanceEmpreinteIdentifiant (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueCorrespondanceEmpreinteIdentifiant vPP = new VueCorrespondanceEmpreinteIdentifiant();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}