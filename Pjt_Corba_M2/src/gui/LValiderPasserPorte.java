package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderPasserPorte implements ActionListener
{

	private VuePasserPorte vm;

	public LValiderPasserPorte (VuePasserPorte vuePasserPorte)
	{
		this.vm=vuePasserPorte;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo 5 !");
	}
}