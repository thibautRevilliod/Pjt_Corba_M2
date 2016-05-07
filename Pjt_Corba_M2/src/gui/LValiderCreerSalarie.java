package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderCreerSalarie implements ActionListener
{

	private VueCreerSalarie vm;

	public LValiderCreerSalarie (VueCreerSalarie vueCreerSalarie)
	{
		this.vm=vueCreerSalarie;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a réaliser pour ajouter une accred
		
		System.out.println("yo 3 !");
	}
}