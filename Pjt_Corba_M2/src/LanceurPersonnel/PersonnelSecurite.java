package LanceurPersonnel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import config.Config;
import modControledAcces.*;

public class PersonnelSecurite {
	
	public static InfoZone[] listeZones;
	public static InfoSalarie[] listeSalaries;
	public static EntiteLogicielleAutorisation monELAutorisation;
	public static EntiteLogicielleAnnuaire monELAnnuaire;
	public static EntiteLogicielleJournalisation monELJournalisation;
	public static String cleAutorisation = "personnel_securite_autorisation";
	public static String cleJournalisation = "personnel_securite_journalisation";
	public static String IOR_EL_autorisation = "";
	public static String IOR_EL_annuaire = "";
	public static String IOR_EL_journalisation = "";
	
	public static void connexionELautorisation (String[] args) {
		if(IOR_EL_autorisation.equals(""))
		{
			connexionELautorisationNS(args);
			System.out.println("[Autorisation] Appel NamingService");
		}
		else
		{
			connexionELautorisationIOR(args);
			System.out.println("[Autorisation] Appel à l'IOR stockée");
		}
	}
	
	public static void connexionELautorisationNS (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
/*
	        // Saisie du nom de l'objet (si utilisation du service de nommage)
	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			String idObj = "ELautorisation";
			
	        // Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot;
	        
	        if(Config.estSoutenanceDistante)
	        {
	        	nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+Config.ipServeur+":2001/NameService"));
	        }else
	        {
	        	nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        }
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELAutorisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELAutorisation));
	        IOR_EL_autorisation = orb.object_to_string(distantELAutorisation);

	        monELAutorisation = EntiteLogicielleAutorisationHelper.narrow(distantELAutorisation);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELautorisationIOR (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);


	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
	        org.omg.CORBA.Object distantELAutorisation = orb.string_to_object(IOR_EL_autorisation);
	        // Casting de l'objet CORBA au type convertisseur euro
	       
	        monELAutorisation = EntiteLogicielleAutorisationHelper.narrow(distantELAutorisation);

     
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELannuaire (String[] args) {
		if(IOR_EL_annuaire.equals(""))
		{
			connexionELannuaireNS(args);
			System.out.println("[Annuaire] Appel NamingService");
		}
		else
		{
			connexionELannuaireIOR(args);
			System.out.println("[Annuaire] Appel à l'IOR stockée");
		}
	}
	
	public static void connexionELannuaireNS (String[] args) {
		
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
	        org.omg.CosNaming.NamingContext nameRoot;
	        
	        if(Config.estSoutenanceDistante)
	        {
	        	nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+Config.ipServeur+":2001/NameService"));
	        }else
	        {
	        	nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        }
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELAnnuaire = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELAnnuaire));
	        IOR_EL_annuaire = orb.object_to_string(distantELAnnuaire);

	        monELAnnuaire = EntiteLogicielleAnnuaireHelper.narrow(distantELAnnuaire);      
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELannuaireIOR (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);


	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
	        org.omg.CORBA.Object distantELAnnuaire = orb.string_to_object(IOR_EL_annuaire);
	        // Casting de l'objet CORBA au type convertisseur euro
	        
	        monELAnnuaire = EntiteLogicielleAnnuaireHelper.narrow(distantELAnnuaire);
       
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELjournalisation (String[] args) {
		if(IOR_EL_journalisation.equals(""))
		{
			connexionELjournalisationNS(args);
			System.out.println("[Journalisation] Appel NamingService");
		}
		else
		{
			connexionELjournalisationIOR(args);
			System.out.println("[Journalisation] Appel à l'IOR stockée");
		}
	}
	
	public static void connexionELjournalisationNS (String[] args) {
		
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
	        org.omg.CosNaming.NamingContext nameRoot;
	        
	        if(Config.estSoutenanceDistante)
	        {
	        	nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@"+Config.ipServeur+":2001/NameService"));
	        }else
	        {
	        	nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        }
	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELJournalisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELJournalisation));
	        IOR_EL_journalisation = orb.object_to_string(distantELJournalisation);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELJournalisation = EntiteLogicielleJournalisationHelper.narrow(distantELJournalisation);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);	        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELjournalisationIOR (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
	        org.omg.CORBA.Object distantELJournalisation = orb.string_to_object(IOR_EL_journalisation);
	        // Casting de l'objet CORBA au type convertisseur euro
	        
	        monELJournalisation = EntiteLogicielleJournalisationHelper.narrow(distantELJournalisation);      
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		connexionELautorisation(args);
		listeZones = monELAutorisation.listeToutesZones();
		System.out.println("liste zones : " + Arrays.toString(listeZones));

		connexionELautorisation(args);
		String idSal = null;
		monELAutorisation.lireAccreditationSalarie(idSal);
		
		connexionELautorisation(args);
		String idZone = null;
		Date jourDebut = null;
		Date jourFin = null;
		Date heureDebut = null;
		Date heureFin = null;
		monELAutorisation.modifierAccreditation(idSal, idZone, jourDebut, jourFin, heureDebut, heureFin);
		
		connexionELautorisation(args);
		monELAutorisation.supprimerAccreditation(idSal, idZone);
		
		connexionELjournalisation(args);
		String qui = null;
		String quoi = null;
		String quand_debut = null;
		String quand_fin = null;
		monELJournalisation.consulter(qui, quoi, quand_debut, quand_fin, cleJournalisation);
		
	}

	public static String getCleAutorisation() {
		return cleAutorisation;
	}

	public static void setCleAutorisation(String cleAutorisation) {
		PersonnelSecurite.cleAutorisation = cleAutorisation;
	}

	public static String getCleJournalisation() {
		return cleJournalisation;
	}

	public static void setCleJournalisation(String cleJournalisation) {
		PersonnelSecurite.cleJournalisation = cleJournalisation;
	}

}
