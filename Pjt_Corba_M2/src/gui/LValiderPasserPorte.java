package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelSecurite;
import LanceurPersonnel.Utilisateur;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderPasserPorte implements ActionListener
{

	private VuePasserPorte vm;

	public LValiderPasserPorte (VuePasserPorte vuePasserPorte)
	{
		this.vm=vuePasserPorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		//TODO : pour le test : empreinte1 | photo1
		String message = null;
		String idSal = "";
		
		if(!vm.getTextField().getText().equals("") && !vm.getTextField_1().getText().equals(""))
		{
			Utilisateur.connexionELporte(main.param);
			
			idSal = Utilisateur.monELPorte.demanderAuthentifier(vm.getTextField_1().getText(),vm.getTextField().getText());
			
			if(!idSal.equals(""))
			{
				Utilisateur.monELPorte.demandeEntrerSortirZone(idSal,vm.getIdZone());
				message = "Bienvenue [les portes s'ouvrent..]";
				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
			}else
			{
				message = "Vous n'êtes pas autorisé à rentrer [les portes se ferment..]";
				JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
			}

		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		vm.setVisible(false);
	}
}