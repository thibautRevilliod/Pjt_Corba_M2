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

public class LValiderVueModifierAccreditation implements ActionListener
{

	private VueModifierAccreditation vm;

	public LValiderVueModifierAccreditation (VueModifierAccreditation vueModifierAccreditation)
	{
		this.vm=vueModifierAccreditation;
	}

	public void actionPerformed(ActionEvent e)
	{
		String message;
		if (!vm.getFormattedTextField().getText().equals("") && !vm.getFormattedTextField_1().getText().equals("") && !vm.getFormattedTextField_2().getText().equals("") 
				&& !vm.getFormattedTextField_3().getText().equals("") && !vm.getIdSalarie().getText().equals("") && !vm.getIdZone().getText().equals(""))
		{
			String idSal = vm.getIdSalarie().getText();
			String idZone = vm.getIdZone().getText();
			
			try {
				PersonnelSecurite.connexionELautorisation(main.param);
				
				SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
				Date jourDebut = formatDate.parse(vm.getFormattedTextField().getText());
				Date jourFin = formatDate.parse(vm.getFormattedTextField_1().getText());
				SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm");
				Date heureDebut = formatHeure.parse(vm.getFormattedTextField_2().getText());
				Date heureFin = formatHeure.parse(vm.getFormattedTextField_3().getText());
				Timestamp tjourDebut = new Timestamp(jourDebut.getTime());
				Timestamp tjourFin = new Timestamp(jourFin.getTime());
				Timestamp theureDebut = new Timestamp(heureDebut.getTime());
				Timestamp theureFin = new Timestamp(heureFin.getTime());
				
				PersonnelSecurite.monELAutorisation.modifierAccreditation(idSal, idZone, new modControledAcces.Date(tjourDebut.toString()), new modControledAcces.Date(tjourFin.toString()), new modControledAcces.Date(theureDebut.toString()), new modControledAcces.Date(theureFin.toString()));
			} catch (ErreurSalarieInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ErreurZoneInexistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			message = "modifierAccreditation : OK";
			JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	
			//fermeture fenêtre
			this.vm.setVisible(false);
			
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
	}
}