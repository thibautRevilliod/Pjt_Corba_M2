package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.CleInconnue;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderVueSupprimerAccreditation implements ActionListener
{

	private VueSupprimerAccreditation vm;

	public LValiderVueSupprimerAccreditation (VueSupprimerAccreditation vueSupprimerAccreditation)
	{
		this.vm=vueSupprimerAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = null;
		if(!vm.getComboBox().getSelectedItem().equals("") && !vm.getComboBox_1().getSelectedItem().equals(""))
		{
			String idSal = (String) vm.getComboBox().getSelectedItem();
			String idZone = (String) vm.getComboBox_1().getSelectedItem();
			
			try {
				PersonnelSecurite personnelSecurite = new PersonnelSecurite();
				personnelSecurite.connexionELautorisation(main.param);
				
				InfoSalarieAccreditation infoSalarieAccreditation = personnelSecurite.monELAutorisation.supprimerAccreditation(idSal, idZone);
				
				message = "Salarie : " + infoSalarieAccreditation.idSal + ": \n";
				
				for(int i = 0; i < infoSalarieAccreditation.listeAccreditationSal.length; i++)
				{
					message += " idZone : " + infoSalarieAccreditation.listeAccreditationSal[i].idZone;
					message += " dateAcreditation : " + infoSalarieAccreditation.listeAccreditationSal[i].dateAcreditation.timestamp;
					message += " heureDebut : " + infoSalarieAccreditation.listeAccreditationSal[i].heureDebut.timestamp;
					message += " heureFin : " + infoSalarieAccreditation.listeAccreditationSal[i].heureFin.timestamp;
					message += " jourDebut : " + infoSalarieAccreditation.listeAccreditationSal[i].jourDebut.timestamp;
					message += " jourFin : " + infoSalarieAccreditation.listeAccreditationSal[i].jourFin.timestamp;
				}
				
			} catch (ErreurSalarieInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ErreurZoneInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			message += "\n supprimerAccreditation : OK";
			JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	
			//fermeture fenêtre
			this.vm.setVisible(false);
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
	}
}