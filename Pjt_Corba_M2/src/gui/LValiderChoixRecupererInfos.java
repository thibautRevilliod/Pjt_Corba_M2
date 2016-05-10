package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import LanceurPersonnel.PersonnelSecurite;
import modControledAcces.CleInconnue;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderChoixRecupererInfos implements ActionListener
{

	private VueChoixRecupererInfos vm;
	
	

	public LValiderChoixRecupererInfos (VueChoixRecupererInfos vueChoixRecupererInfos)
	{
		this.vm=vueChoixRecupererInfos;
	}

	public void actionPerformed(ActionEvent e)
	{	
		System.out.println("ok ça ouvre la prochaine fenetre! ");
		VueRecupererInfos vRI = new VueRecupererInfos();
		vRI.setVisible(true);
		vRI.setLocation(800, 300);
		
		
	}
}