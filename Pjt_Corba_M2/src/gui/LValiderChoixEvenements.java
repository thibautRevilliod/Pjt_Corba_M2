package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.CleInconnue;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderChoixEvenements implements ActionListener
{

	private VueChoixEvenements vm;
	
	

	public LValiderChoixEvenements (VueChoixEvenements vueChoixEvenements)
	{
		this.vm=vueChoixEvenements;
	}

	public void actionPerformed(ActionEvent e)
	{	
		JTable table = null;
		String message;
		VueConsulterEvenements vce;
		
		if (!vm.getFormattedTextField().getText().equals("") && !vm.getFormattedTextField_1().getText().equals("") && 
				!vm.getComboBox().getSelectedItem().equals("") && !vm.getComboBox_1().getSelectedItem().equals(""))
		{
			try {
				SimpleDateFormat formatDateHeure = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Date dateHeureDebut = formatDateHeure.parse(vm.getFormattedTextField().getText());
				Date dateHeureFin = formatDateHeure.parse(vm.getFormattedTextField_1().getText());
				Timestamp tdateHeureDebut = new Timestamp(dateHeureDebut.getTime());
				Timestamp tdateHeureFin = new Timestamp(dateHeureFin.getTime());
				
				PersonnelSecurite personnelSecurite = new PersonnelSecurite();
				personnelSecurite.connexionELjournalisation(main.param);

				EvenementJournalisation[] evenementJournalisation = personnelSecurite.monELJournalisation.consulter((String)vm.getComboBox().getSelectedItem(), (String)vm.getComboBox_1().getSelectedItem(), tdateHeureDebut.toString(), tdateHeureFin.toString(), personnelSecurite.cleJournalisation);
				
				Object rowData[][] = new Object[evenementJournalisation.length][6];
				
				for(int i = 0 ; i < evenementJournalisation.length; i++)
				{
					rowData[i][0] = evenementJournalisation[i].accesZoneSal.idSal;
					rowData[i][1] = evenementJournalisation[i].accesZoneSal.idZone;
					rowData[i][2] = evenementJournalisation[i].accesZoneSal.jourHeure.timestamp;
					rowData[i][3] = evenementJournalisation[i].accesZoneSal.statutAcces;
					rowData[i][4] = evenementJournalisation[i].operation;
					rowData[i][5] = evenementJournalisation[i].contenuOperation;
				}
				
				Object columnNames[] = { "idSal", "idZone", "jourHeure", "statutAcces", "operation", "contenuOperation"};
				table = new JTable(rowData, columnNames);
				
			} catch (CleInconnue e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			vce = new VueConsulterEvenements(table);
			vce.setVisible(true);
			vce.setLocation(500, 200);
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
	}
}