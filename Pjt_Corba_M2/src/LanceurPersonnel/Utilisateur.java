package LanceurPersonnel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import config.Config;
import modControledAcces.*;

public class Utilisateur {
	
	public static InfoZone[] listeZones;
	public static InfoSalarie[] listeSalaries;
	public static EntiteLogiciellePorte monELPorte;
	public static EntiteLogicielleAnnuaire monELAnnuaire;
	public static String IOR_EL_porte = "";
	public static String IOR_EL_annuaire = "";
	
	public static void connexionELporte (String[] args) {
		if(IOR_EL_porte.equals(""))
		{
			connexionELporteNS(args);
			System.out.println("[Porte] Appel NamingService");
		}
		else
		{
			connexionELporteIOR(args);
			System.out.println("[Porte] Appel à l'IOR stockée");
		}
	}
	
	public static void connexionELporteNS (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Saisie du nom de l'objet (si utilisation du service de nommage)
/*	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
*/
			String idObj = "ELporte";
			
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
	        org.omg.CORBA.Object distantELPorte = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELPorte));
	        IOR_EL_porte = orb.object_to_string(distantELPorte);

	        monELPorte = EntiteLogiciellePorteHelper.narrow(distantELPorte);
       
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void connexionELporteIOR (String[] args) {
		
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
	        org.omg.CORBA.Object distantELPorte = orb.string_to_object(IOR_EL_porte);
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELPorte = EntiteLogiciellePorteHelper.narrow(distantELPorte);     
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

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

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

	public static void main(String[] args) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		
		connexionELporte(args);
		String photo = null;
		String empreinte = null;
		monELPorte.demanderAuthentifier(photo,empreinte);
		
		connexionELporte(args);
		String idSal = null;
		String idZone = null;
		monELPorte.demandeEntrerSortirZone(idSal, idZone);
		
		connexionELporte(args);
		empreinte = null;
		monELPorte.demanderModifierEmpreinte(idSal, empreinte);
		
	}

}
