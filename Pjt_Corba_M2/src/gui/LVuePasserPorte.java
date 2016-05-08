package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoOperation;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVuePasserPorte implements ActionListener
{

	private VueMenuPorte vm;

	public LVuePasserPorte (VueMenuPorte vueMenuPorte)
	{
		this.vm=vueMenuPorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		VuePasserPorte vPP = new VuePasserPorte(remplirComboBoxSal());
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	private InfoZone[] listeZones() {
		PersonnelSecurite personnelSecurite = new PersonnelSecurite();
		personnelSecurite.connexionELautorisation(main.param);
		InfoZone[] infoZone = personnelSecurite.monELAutorisation.listeToutesZones();
		
		return infoZone;
	}
	
	private JComboBox remplirComboBoxSal()
	{
		JComboBox _comboBox = new JComboBox();
		InfoZone[] iz = listeZones();
		
		_comboBox.addItem("");
		
		for(int i = 0; i < iz.length; i++)
		{
			_comboBox.addItem(iz[i].idZone);
		}
		return _comboBox;
	}
}