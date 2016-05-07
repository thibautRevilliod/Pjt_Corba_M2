package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LVueSupprimerEmpreinte implements ActionListener
{

	private VueMenuRH vm;

	public LVueSupprimerEmpreinte (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueSupprimerEmpreinte vPP = new VueSupprimerEmpreinte();
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
}