package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoOperation;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVueChoixRecupererNomPhoto implements ActionListener
{

	private VueMenuAnnuaire vm;

	public LVueChoixRecupererNomPhoto (VueMenuAnnuaire vueMenuAnnuaire)
	{
		this.vm=vueMenuAnnuaire;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueChoixRecupererNomPhoto vRNP = new VueChoixRecupererNomPhoto();
		vRNP.setVisible(true);
		vRNP.setLocation(800, 300);
		
	}
}