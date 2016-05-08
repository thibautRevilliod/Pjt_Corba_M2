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
		String idSal = "";
		
		if(!vm.getTextField().getText().equals("") && !vm.getTextField_1().getText().equals(""))
		{
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.connexionELporte(main.param);
			
			idSal = utilisateur.monELPorte.demanderAuthentifier(vm.getTextField_2().getText(),vm.getTextField().getText());
			
			if(!idSal.equals(""))
			{
				utilisateur.monELPorte.demanderModifierEmpreinte(idSal,vm.getTextField_1().getText());
				message = "Empreinte modifiée";
				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
			}else
			{
				message = "Vous n'êtes pas autorisé à changer votre empreinte";
				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		vm.setVisible(false);
	}
}