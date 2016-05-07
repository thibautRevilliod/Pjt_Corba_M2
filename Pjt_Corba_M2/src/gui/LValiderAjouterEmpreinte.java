package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderAjouterEmpreinte implements ActionListener
{

	private VueAjouterEmpreinte vm;

	public LValiderAjouterEmpreinte (VueAjouterEmpreinte vueAjouterEmpreinte)
	{
		this.vm=vueAjouterEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo 2 !");
	}
}