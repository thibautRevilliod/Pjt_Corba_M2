package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class LVueAjouterEmpreinte implements ActionListener
{

	private VueMenuRH vm;

	public LVueAjouterEmpreinte (VueMenuRH vueMenuRH)
	{
		this.vm=vueMenuRH;
	}

	public void actionPerformed(ActionEvent e)
	{
		VueAjouterEmpreinte vPP = new VueAjouterEmpreinte(remplirComboBoxSal());
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	private InfoSalarie[] listeIdSal() {
		PersonnelSecurite.connexionELannuaire(main.param);
		InfoSalarie[] infoSalarie = PersonnelSecurite.monELAnnuaire.listeTousSalaries();
		
		return infoSalarie;
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
}