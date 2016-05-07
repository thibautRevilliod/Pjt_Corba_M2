package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueCreerSalarie implements ActionListener
{

	private VueMenuAnnuaire vm;

	public LVueCreerSalarie (VueMenuAnnuaire vueMenuAnnuaire)
	{
		this.vm=vueMenuAnnuaire;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueCreerSalarie vPP = new VueCreerSalarie();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}