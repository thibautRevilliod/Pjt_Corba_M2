package gui;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class main {
	public static String[] param;
	public static void main(String[] args) 
	{
		param = args;
		
		VueMenuPorte menuPorte;
		VueMenuRH menuRH;
		VueMenuAnnuaire menuAnnuaire;
		VueMenuSecurite menuSecurite;
		VueParametragePorte paramPorte;
	
		//pour ouvrir la fenetre de paramétrage de la porte: 
	/*	paramPorte = new VueParametragePorte();
		paramPorte.setVisible(true);
		paramPorte.setLocation(500, 200);
	*/	
		// pour ouvrir le menu Porte 		
		
		/* A ne jamais lancer sans passer par la fenetre de parametrage de la porte !
		menuPorte = new VueMenuPorte();
		menuPorte.setVisible(true);
		menuPorte.setLocation(500, 200);
*/
		
		// pour ouvrir le menu RH 		
		
		/*menuRH = new VueMenuRH();
		menuRH.setVisible(true);
		menuRH.setLocation(500, 200);
	*/
		
	// pour ouvrir le menu Annuaire		
		
		menuAnnuaire = new VueMenuAnnuaire();
		menuAnnuaire.setVisible(true);
		menuAnnuaire.setLocation(500, 200);
		
			
		
	// pour ouvrir le menu Securite		
		/*
		menuSecurite = new VueMenuSecurite();
		menuSecurite.setVisible(true);
		menuSecurite.setLocation(500, 200);
		*/
	}

}