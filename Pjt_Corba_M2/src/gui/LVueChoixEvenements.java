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

public class LVueChoixEvenements implements ActionListener
{

	private VueMenuSecurite vm;

	public LVueChoixEvenements (VueMenuSecurite vueMenuSecurite)
	{
		this.vm=vueMenuSecurite;
	}

	public void actionPerformed(ActionEvent e)
	{
		
		VueChoixEvenements vPP = new VueChoixEvenements(remplirComboBoxSal(),remplirComboBoxOperation());
		
		vPP.setVisible(true);
		vPP.setLocation(800, 300);
	}
	
	private InfoSalarie[] listeIdSal() {
		PersonnelSecurite.connexionELannuaire(main.param);
		InfoSalarie[] infoSalarie = PersonnelSecurite.monELAnnuaire.listeTousSalaries();
		
		return infoSalarie;
	}
	
	private InfoOperation[] listeOpreations() {
		PersonnelSecurite.connexionELjournalisation(main.param);
		InfoOperation[] infoOperation = PersonnelSecurite.monELJournalisation.listeOperations();
		
		return infoOperation;
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
	
	private JComboBox remplirComboBoxOperation()
	{
		JComboBox _comboBox = new JComboBox();
		
		InfoOperation[] io = listeOpreations();
		
		_comboBox.addItem("");

		for(int i = 0; i < io.length; i++)
		{
			_comboBox.addItem(io[i].operation);
		}
		return _comboBox;
	}
}