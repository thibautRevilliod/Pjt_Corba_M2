package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import LanceurPersonnel.PersonnelRH;
import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.CleInconnue;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderChoixRecupererInfos implements ActionListener
{

	private VueChoixRecupererInfos vm;
	
	

	public LValiderChoixRecupererInfos (VueChoixRecupererInfos vueChoixRecupererInfos)
	{
		this.vm=vueChoixRecupererInfos;
	}

	public void actionPerformed(ActionEvent e)
	{	
		String message = null;
		if(!vm.getComboBox().getSelectedItem().equals(""))
		{
			String idSal = (String) vm.getComboBox().getSelectedItem();
			
			try {
				PersonnelRH.connexionELannuaire(main.param);
				
				InfoSalarie infoSalarie = PersonnelRH.monELAnnuaire.infosSalarie(idSal, PersonnelRH.cleAnnuaire);
				
				VueRecupererInfos vRI = new VueRecupererInfos(infoSalarie);
				vRI.setVisible(true);
				vRI.setLocation(800, 300);
				
			} catch (ErreurSalarieInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CleInconnue e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			//fermeture fenêtre
			this.vm.setVisible(false);
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}	
		
	}
}