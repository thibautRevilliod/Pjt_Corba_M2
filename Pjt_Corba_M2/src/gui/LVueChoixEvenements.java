package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVueChoixEvenements implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueChoixEvenements (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		
		VueChoixEvenements vPP = new VueChoixEvenements(remplirComboBoxSal(),remplirComboBoxZone());
		
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	private InfoSalarie[] listeIdSal() {
		PersonnelSecurite personnelSecurite = new PersonnelSecurite();
		personnelSecurite.connexionELannuaire(main.param);
		InfoSalarie[] infoSalarie = personnelSecurite.monELAnnuaire.listeTousSalaries();
		
		return infoSalarie;
	}
	
	private InfoZone[] listeIdZone() {
		PersonnelSecurite personnelSecurite = new PersonnelSecurite();
		personnelSecurite.connexionELautorisation(main.param);
		InfoZone[] infoZone = personnelSecurite.monELAutorisation.listeToutesZones();
		
		return infoZone;
	}
	
	private JComboBox remplirComboBoxSal()
	{
		JComboBox _comboBox = new JComboBox();
		InfoSalarie[] is = listeIdSal();
		
		_comboBox.addItem("");
		
		for(int i = 0; i < is.length; i++)
		{
			_comboBox.addItem(is[i].idSal);
		}
		return _comboBox;
	}
	
	private JComboBox remplirComboBoxZone()
	{
		JComboBox _comboBox = new JComboBox();
		
		InfoZone[] iz = listeIdZone();
		
		_comboBox.addItem("");

		for(int i = 0; i < iz.length; i++)
		{
			_comboBox.addItem(iz[i].idZone);
		}
		return _comboBox;
	}
}