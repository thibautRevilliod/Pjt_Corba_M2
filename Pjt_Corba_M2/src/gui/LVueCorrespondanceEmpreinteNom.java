package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueCorrespondanceEmpreinteNom implements ActionListener
{

	private VueMenuRH vm;

	public LVueCorrespondanceEmpreinteNom (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueCorrespondanceEmpreinteNom vPP = new VueCorrespondanceEmpreinteNom();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}