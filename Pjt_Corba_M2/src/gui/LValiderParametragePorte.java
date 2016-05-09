package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import LanceurPersonnel.PersonnelSecurite;
import LanceurPersonnel.Utilisateur;
import modControledAcces.InfoSalarieAccreditation;

public class LValiderParametragePorte implements ActionListener
{

	private VueParametragePorte vm;

	public LValiderParametragePorte (VueParametragePorte vueParametragePorte)
	{
		this.vm=vueParametragePorte;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Ouvrir le menu porte");
		VueMenuPorte vMP = new VueMenuPorte();
		vMP.setVisible(true);
		vMP.setLocation(800, 300);
	
	}
}