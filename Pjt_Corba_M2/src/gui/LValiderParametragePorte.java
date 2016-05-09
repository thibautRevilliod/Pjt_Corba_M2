package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelSecurite;
import LanceurPersonnel.Utilisateur;
import modControledAcces.ErreurPorteExistant;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderParametragePorte implements ActionListener
{

	private VueParametragePorte vm;

	public LValiderParametragePorte (VueParametragePorte vueParametragePorte)
	{
		this.vm=vueParametragePorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = null;
		String idPorte = "";
		
		if(!vm.getTextField().getText().equals("") && !vm.getComboBox().getSelectedItem().equals(""))
		{
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.connexionELporte(main.param);
			
			try {
				idPorte = utilisateur.monELPorte.creerPorte(vm.getTextField().getText(),(String)vm.getComboBox().getSelectedItem());
			} catch (ErreurPorteExistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(idPorte.equals("-2"))
			{
				message = "La porte existe déjà";
				JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
			}else if(idPorte.equals(""))
			{
				message = "Erreur dans les paramètres que vous avez renseigné";
				JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
			}else{
				vm.setVisible(false);
				VueMenuPorte vMP = new VueMenuPorte((String)vm.getComboBox().getSelectedItem());
				vMP.setVisible(true);
				vMP.setLocation(800, 300);
			}
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}	
	}
}