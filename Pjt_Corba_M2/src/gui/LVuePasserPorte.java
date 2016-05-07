package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVuePasserPorte implements ActionListener
{

	private VueMenuPorte vm;

	public LVuePasserPorte (VueMenuPorte vueMenuPorte)
	{
		this.vm=vueMenuPorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		VuePasserPorte vPP = new VuePasserPorte();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}