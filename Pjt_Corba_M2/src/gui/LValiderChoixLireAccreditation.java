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
import modControledAcces.InfoSalarieAccreditation;

public class LValiderChoixLireAccreditation implements ActionListener
{

	private VueChoixLireAccreditation vm;
	
	

	public LValiderChoixLireAccreditation (VueChoixLireAccreditation vueChoixLireAccreditation)
	{
		this.vm=vueChoixLireAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueLireAccreditation vce;
		String message;
		JTable table = null;
		
		if(!vm.getComboBox().getSelectedItem().equals(""))
		{
			try {
				PersonnelSecurite.connexionELautorisation(main.param);

				InfoSalarieAccreditation infoSalarieAccreditation = PersonnelSecurite.monELAutorisation.lireAccreditationSalarie((String)vm.getComboBox().getSelectedItem());
				
				Object rowData[][] = new Object[infoSalarieAccreditation.listeAccreditationSal.length][7];
				
				for(int i = 0 ; i < infoSalarieAccreditation.listeAccreditationSal.length; i++)
				{
					rowData[i][0] = infoSalarieAccreditation.idSal;
					rowData[i][1] = infoSalarieAccreditation.listeAccreditationSal[i].idZone;
					rowData[i][2] = infoSalarieAccreditation.listeAccreditationSal[i].dateAcreditation.timestamp;
					rowData[i][3] = infoSalarieAccreditation.listeAccreditationSal[i].heureDebut.timestamp;
					rowData[i][4] = infoSalarieAccreditation.listeAccreditationSal[i].heureFin.timestamp;
					rowData[i][5] = infoSalarieAccreditation.listeAccreditationSal[i].jourDebut.timestamp;
					rowData[i][6] = infoSalarieAccreditation.listeAccreditationSal[i].jourFin.timestamp;
				}
				
				Object columnNames[] = { "idSal", "idZone", "dateAcreditation", "heureDebut", "heureFin", "jourDebut", "jourFin"};
				table = new JTable(rowData, columnNames);
				
			} catch (ErreurSalarieInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			vce = new VueLireAccreditation(table);
			vce.setVisible(true);
			vce.setTable(table);
			vce.setLocation(500, 200);
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
}