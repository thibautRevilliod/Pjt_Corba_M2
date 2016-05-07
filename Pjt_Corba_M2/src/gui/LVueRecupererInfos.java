package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueRecupererInfos implements ActionListener
{

	private VueMenuAnnuaire vm;

	public LVueRecupererInfos (VueMenuAnnuaire vueMenuAnnuaire)
	{
		this.vm=vueMenuAnnuaire;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueRecupererInfos vPP = new VueRecupererInfos();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}