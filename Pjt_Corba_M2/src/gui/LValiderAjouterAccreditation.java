package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LValiderAjouterAccreditation implements ActionListener
{

	private VueAjouterAccreditation vm;

	public LValiderAjouterAccreditation (VueAjouterAccreditation vueAjouterAccreditation)
	{
		this.vm=vueAjouterAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{

		
		// ici l'action a r�aliser pour ajouter une accred
		
		System.out.println("yo");
	}
}