package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelRH;
import LanceurPersonnel.Utilisateur;
import modControledAcces.ErreurSalarieExistant;

public class LValiderCreerSalarie implements ActionListener
{

	private VueCreerSalarie vm;

	public LValiderCreerSalarie (VueCreerSalarie vueCreerSalarie)
	{
		this.vm=vueCreerSalarie;
	}

	public void actionPerformed(ActionEvent e)
	{

		String message = null;
		String idSal = "";
		
		//ajouter dans la seconde partie (getRdbtnNon) du test les champs "heureDebut, heureFin, jourDebut, jourFin"
		if(((!vm.getTextField_4().getText().equals("") && !vm.getTextField_1().getText().equals("") && !vm.getTextField_2().getText().equals("") &&
				!vm.getTextField_3().getText().equals("")) && vm.getRdbtnOui().isSelected()) ||
			((!vm.getTextField_4().getText().equals("") && !vm.getTextField_1().getText().equals("") && !vm.getTextField_2().getText().equals("") &&
				!vm.getTextField_3().getText().equals("") && !vm.getFormattedTextField_1().getText().equals("") && !vm.getFormattedTextField_2().getText().equals("")
				 && !vm.getFormattedTextField_3().getText().equals("") && !vm.getFormattedTextField_4().getText().equals("")) && vm.getRdbtnNon().isSelected()))
		{
			PersonnelRH.connexionELannuaire(main.param);
			
			try{
				SimpleDateFormat formatDateHeure = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Date dateHeureFinValidite = formatDateHeure.parse(vm.getjFormattedTextField().getText());
				Timestamp tdateHeureFinValidite = new Timestamp(dateHeureFinValidite.getTime());
	
				if(vm.getRdbtnOui().isSelected())
				{
					idSal = PersonnelRH.monELAnnuaire.creerSalarie(vm.getTextField_2().getText(), vm.getTextField_4().getText(), vm.getTextField_3().getText(), vm.getTextField_1().getText(), new modControledAcces.Date(""), new modControledAcces.Date(""), new modControledAcces.Date(""), new modControledAcces.Date(""), new modControledAcces.Date(tdateHeureFinValidite.toString()), true);
				}else
				{
					//remplir avec les champs correspondant getjFormattedTextField_1 , ????
					SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
					SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm");
					Date heureDebut = formatHeure.parse(vm.getFormattedTextField_1().getText());
					Date heureFin = formatHeure.parse(vm.getFormattedTextField_2().getText());
					Date dateDebut = formatDate.parse(vm.getFormattedTextField_3().getText());
					Date dateFin = formatDate.parse(vm.getFormattedTextField_4().getText());
					Timestamp theureDebut = new Timestamp(heureDebut.getTime());
					Timestamp theureFin = new Timestamp(heureFin.getTime());
					Timestamp tdateDebut = new Timestamp(dateDebut.getTime());
					Timestamp tdateFin = new Timestamp(dateFin.getTime());
					idSal = PersonnelRH.monELAnnuaire.creerSalarie(vm.getTextField_2().getText(), vm.getTextField_4().getText(), vm.getTextField_3().getText(), vm.getTextField_1().getText(), new modControledAcces.Date(theureDebut.toString()), new modControledAcces.Date(theureFin.toString()), new modControledAcces.Date(tdateDebut.toString()), new modControledAcces.Date(tdateFin.toString()), new modControledAcces.Date(tdateHeureFinValidite.toString()), false);
				}
				
				if(idSal.equals(""))
				{
					message = "Erreur execution";
					JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
				}else if(idSal.equals("-2"))
				{
					message = "Le salarié existe déjà";
					JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.INFORMATION_MESSAGE);
					
				}else
				{
					message = "Salarié créé avec l'id : " + idSal;
					JOptionPane.showMessageDialog(vm, message, "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				vm.setVisible(false);
			} catch (ErreurSalarieExistant e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			message = "Vous devez remplir les champs";
			JOptionPane.showMessageDialog(vm, message, "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}