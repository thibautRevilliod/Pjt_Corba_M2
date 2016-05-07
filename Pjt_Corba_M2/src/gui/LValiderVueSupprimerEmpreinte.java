package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderVueSupprimerEmpreinte implements ActionListener
{

	private VueSupprimerEmpreinte vm;

	public LValiderVueSupprimerEmpreinte (VueSupprimerEmpreinte vueSupprimerEmpreinte)
	{
		this.vm=vueSupprimerEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo 6 !");
	}
}