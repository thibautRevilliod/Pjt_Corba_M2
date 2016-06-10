package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVueAjouterAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueAjouterAccreditation (VueMenuSecurite vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueAjouterAccreditation vPP = new VueAjouterAccreditation(remplirComboBoxSal(), remplirComboBoxZone());
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	private InfoSalarie[] listeIdSal() {
		PersonnelSecurite.connexionELannuaire(main.param);
		InfoSalarie[] infoSalarie = PersonnelSecurite.monELAnnuaire.listeTousSalaries();
		
		return infoSalarie;
	}
	
	private InfoZone[] listeIdZone() {
		PersonnelSecurite.connexionELautorisation(main.param);
		InfoZone[] infoZone = PersonnelSecurite.monELAutorisation.listeToutesZones();
		
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
		
		InfoZone[] io = listeIdZone();
		
		_comboBox.addItem("");

		for(int i = 0; i < io.length; i++)
		{
			_comboBox.addItem(io[i].idZone);
		}
		return _comboBox;
	}
}