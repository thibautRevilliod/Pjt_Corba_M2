package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueMenuAnnuaire implements ActionListener
{

	private VueMenuRH vm;

	public LVueMenuAnnuaire (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueMenuAnnuaire vPP = new VueMenuAnnuaire();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}