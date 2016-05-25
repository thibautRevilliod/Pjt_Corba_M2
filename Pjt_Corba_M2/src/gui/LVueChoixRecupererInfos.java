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

public class LVueChoixRecupererInfos implements ActionListener
{

	private VueMenuAnnuaire vm;

	public LVueChoixRecupererInfos (VueMenuAnnuaire vueMenuAnnuaire)
	{
		this.vm=vueMenuAnnuaire;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueChoixRecupererInfos vRI = new VueChoixRecupererInfos(remplirComboBoxSal());
		vRI.setVisible(true);
		vRI.setLocation(800, 300);
		
	}
	
	private InfoSalarie[] listeIdSal() {
		PersonnelSecurite.connexionELannuaire(main.param);
		InfoSalarie[] infoSalarie = PersonnelSecurite.monELAnnuaire.listeTousSalaries();
		
		return infoSalarie;
	}
	
	private JComboBox remplirComboBoxSal()
	{
		InfoSalarie[] is = listeIdSal();
		
		JComboBox _comboBox = new JComboBox();
		
		_comboBox.addItem("");
		
		for(int i = 0; i < is.length; i++)
		{
			_comboBox.addItem(is[i].idSal);
		}
		return _comboBox;
	}
}