package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderVueSupprimerAccreditation implements ActionListener
{

	private VueSupprimerAccreditation vm;

	public LValiderVueSupprimerAccreditation (VueSupprimerAccreditation vueSupprimerAccreditation)
	{
		this.vm=vueSupprimerAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo DA !");
	}
}