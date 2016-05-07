package impl;

import bdd.BddJDBC_EL_Porte;
import config.Config;
import gui.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import bdd.BddJDBC_EL_Autorisation;
import modControledAcces.AccesZone;
import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EmpreinteExistante;
import modControledAcces.EmpreinteIncorrecte;
import modControledAcces.EntiteLogicielleAnnuaire;
import modControledAcces.EntiteLogiciellePortePOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogicielleEmpreinteHelper;
import modControledAcces.EntiteLogicielleJournalisation;
import modControledAcces.EntiteLogicielleJournalisationHelper;
import modControledAcces.EntiteLogicielleAnnuaireHelper;
import modControledAcces.EntiteLogicielleAutorisation;
import modControledAcces.EntiteLogicielleAutorisationHelper;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieExistant;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarie;

public class EntiteLogiciellePorteImpl extends EntiteLogiciellePortePOA {
	
	public static EntiteLogicielleAnnuaire monELAnnuaire;
	public static EntiteLogicielleEmpreinte monELEmpreinte;
	public static EntiteLogicielleAutorisation monELAutorisation;
	public static EntiteLogicielleJournalisation monELJournalisation;
	public static String cleEmpreinte = "EntiteLogiciellePorte_empreinte";
	public static BddJDBC_EL_Porte bddJDBC_EL_Porte = new BddJDBC_EL_Porte("BD_Porte");

	@Override
	public void afficherMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demandeEntrerSortirZone(String idSal, String idZone) {
		// TODO Auto-generated method stub
		connexionELautorisation(main.param);
		try {
			monELAutorisation.verifierAutorisation(idSal, idZone);
		} catch (ErreurSalarieInexistant e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErreurZoneInexistant e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date d = new java.util.Date();
		Timestamp tdate = new Timestamp(d.getTime());
		AccesZone accesZone = new AccesZone(idSal, idZone, true, new Date(tdate.toString()));
		connexionELjournalisation(main.param);
		EvenementJournalisation evenementJournalisation = new EvenementJournalisation(accesZone, "demandeEntrerSortirZone", "idSal"+idSal+ "idZone"+idZone);
		monELJournalisation.enregistrerEvenement(evenementJournalisation);
		
	}

	@Override
	public void demanderAuthentifier(String photo) {
		// TODO Auto-generated method stub
		connexionELannuaire(main.param);
		try {
			monELAnnuaire.sauthentifier(photo);
		} catch (ErreurSalarieInexistant e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String empreinte = null;
		
		connexionELempreinte(main.param);
		String idSal = null;
		try {
			monELEmpreinte.verifierCorrespondance(idSal, empreinte, cleEmpreinte);
		} catch (ErreurSalarieInexistant e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CleInconnue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmpreinteIncorrecte e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void demanderModifierEmpreinte(String idSal, String empreinte) {
		// TODO Auto-generated method stub
		
		connexionELempreinte(main.param);
		try {
			monELEmpreinte.modifierEmpreinte(idSal, empreinte, cleEmpreinte);
		} catch (EmpreinteExistante e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CleInconnue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmpreinteIncorrecte e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void connexionELannuaire (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
/*	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			String idObj = "ELannuaire";
			
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELannuaire = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELannuaire));
	        Config.IOR_EL_Annuaire = orb.object_to_string(distantELannuaire);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELAnnuaire = EntiteLogicielleAnnuaireHelper.narrow(distantELannuaire);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void connexionELempreinte (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
/*	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			String idObj = "ELempreinte";
			
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELempreinte = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELempreinte));
	        Config.IOR_EL_Empreinte = orb.object_to_string(distantELempreinte);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELEmpreinte = EntiteLogicielleEmpreinteHelper.narrow(distantELempreinte);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void connexionELautorisation (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
/*	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			
			String idObj = "ELautorisation";
			
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELautorisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELautorisation));
	        Config.IOR_EL_Autorisation = orb.object_to_string(distantELautorisation);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELAutorisation = EntiteLogicielleAutorisationHelper.narrow(distantELautorisation);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void connexionELjournalisation (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
/*	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			String idObj = "ELjournalisation";
			
	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELjournalisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELjournalisation));
	        Config.IOR_EL_Journalisation = orb.object_to_string(distantELjournalisation);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELJournalisation = EntiteLogicielleJournalisationHelper.narrow(distantELjournalisation);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
