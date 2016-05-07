package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueModifierEmpreinte implements ActionListener
{

	private VueMenuPorte vm;

	public LVueModifierEmpreinte (VueMenuPorte vueMenuPorte)
	{
		this.vm=vueMenuPorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueModifierEmpreinte vPP = new VueModifierEmpreinte();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}