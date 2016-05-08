package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoOperation;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVueSupprimerAccreditation implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueSupprimerAccreditation (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{	
		//TODO : la comboBoxZone bug à l'affichage : problème graphique de repaint ? actualisation ? ....
		VueSupprimerAccreditation vPP = new VueSupprimerAccreditation(remplirComboBoxSal(),remplirComboBoxZone());
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
		
		InfoZone[] io = listeIdZone();
		
		_comboBox.addItem("");

		for(int i = 0; i < io.length; i++)
		{
			_comboBox.addItem(io[i].idZone);
		}
		return _comboBox;
	}
}