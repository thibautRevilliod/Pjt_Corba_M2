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
	private String idZone;

	public LVuePasserPorte (VueMenuPorte vueMenuPorte, String _idZone)
	{
		this.vm=vueMenuPorte;
		this.idZone = _idZone;
	}

	public void actionPerformed(ActionEvent e)
	{
		VuePasserPorte vPP = new VuePasserPorte(idZone);
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	
}