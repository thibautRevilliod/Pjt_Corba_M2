package LanceurPersonnel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import config.Config;
import modControledAcces.*;

public class PersonnelRH {
	
	public static InfoZone[] listeZones;
	public static InfoSalarie[] listeSalaries;
	public static EntiteLogicielleEmpreinte monELEmpreinte;
	public static EntiteLogicielleAnnuaire monELAnnuaire;
	public static String cleEmpreinte = "personnel_rh_empreinte";
	
	public static void connexionELempreinte (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELEmpreinte = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELEmpreinte));
	        Config.IOR_EL_Empreinte = orb.object_to_string(distantELEmpreinte);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELEmpreinte = EntiteLogicielleEmpreinteHelper.narrow(distantELEmpreinte);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELannuaire (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELAnnuaire = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELAnnuaire));
	        Config.IOR_EL_Empreinte = orb.object_to_string(distantELAnnuaire);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELAnnuaire = EntiteLogicielleAnnuaireHelper.narrow(distantELAnnuaire);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		
		connexionELempreinte(args);
		String empreinte;
		monELEmpreinte.getCorrespondance(empreinte, cleEmpreinte);
		
		connexionELannuaire(args);
		String idSal;
		monELAnnuaire.infosSalarie(idSal);
		
		connexionELempreinte(args);
		monELEmpreinte.supprimerEmpreinte(idSal, cleEmpreinte);
		
		connexionELempreinte(args);
		monELEmpreinte.ajouterEmpreinte(idSal, empreinte, cleEmpreinte);
		
		connexionELempreinte(args);
		monELEmpreinte.verifierCorrespondance(idSal, empreinte, cleEmpreinte);
		
		connexionELannuaire(args);
		String mdp;
		String prenom;
		String nom;
		String photo;
		Date heureDebut;
		Date heureFin;
		Date jourDebut;
		Date jourFin;
		boolean estPermanent = true;
		//TODO renommer dureeeValiditeCompte
		short dureeValidationCompte;
		monELAnnuaire.creerSalarie(mdp, nom, prenom, photo, heureDebut, heureFin, jourDebut, jourFin, dureeValidationCompte, estPermanent);
		
		connexionELannuaire(args);
		monELAnnuaire.recupererNomPhotoSalarie(idSal);
		
	}

}
