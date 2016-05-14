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
import modControledAcces.EmpreinteIncorrecte;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderCorrespondanceEmpreinteIdentifiant implements ActionListener
{

	private VueCorrespondanceEmpreinteIdentifiant vm;
	
	

	public LValiderCorrespondanceEmpreinteIdentifiant (VueCorrespondanceEmpreinteIdentifiant vueCorrespondanceEmpreinteIdentifiant)
	{
		this.vm=vueCorrespondanceEmpreinteIdentifiant;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = "";
		if(!vm.getListeSalaries().getSelectedItem().equals("") && !vm.getEmpreinte().getText().equals(""))
		{
			String salarie = (String) vm.getListeSalaries().getSelectedItem();
			String empreinte = (String) vm.getEmpreinte().getText();


			boolean isCorrespondanceOK;

					
					try {
						isCorrespondanceOK = PersonnelRH.monELEmpreinte.verifierCorrespondance(salarie, empreinte, PersonnelRH.cleEmpreinte);
						
						if(!isCorrespondanceOK)
						{
							message = "L'empreinte fournie ne correspond pas à cet identifiant";
							JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
						}else
						{
							message = "L'empreinte fournie  correspond à cet identifiant";
							JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
						}
						vm.setVisible(false);
						
					} catch (ErreurSalarieInexistant e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CleInconnue e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EmpreinteIncorrecte e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				


		
		}
			
		
	}
}