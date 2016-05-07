package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderModifierEmpreinte implements ActionListener
{

	private VueModifierEmpreinte vm;

	public LValiderModifierEmpreinte (VueModifierEmpreinte vueModifierEmpreinte)
	{
		this.vm=vueModifierEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo 4 !");
	}
}