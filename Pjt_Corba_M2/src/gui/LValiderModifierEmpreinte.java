package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.Utilisateur;

public class LValiderModifierEmpreinte implements ActionListener
{

	private VueModifierEmpreinte vm;

	public LValiderModifierEmpreinte (VueModifierEmpreinte vueModifierEmpreinte)
	{
		this.vm=vueModifierEmpreinte;
	}

	public void actionPerformed(ActionEvent e)
	{

		String message = null;
		
		if(!vm.getTextField().getText().equals("") && !vm.getTextField_1().getText().equals(""))
		{
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.connexionELporte(main.param);
			
		//	res = utilisateur.monELPorte.demanderModifierEmpreinte(idSal, empreinte);
			
//			if(res)
//			{
//				message = "Bienvenue [les portes s'ouvrent..]";
//				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
//			}else
//			{
//				message = "Vous n'êtes pas autorisé à rentrer [les portes se ferment..]";
//				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
//			}
//			
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
	}
}