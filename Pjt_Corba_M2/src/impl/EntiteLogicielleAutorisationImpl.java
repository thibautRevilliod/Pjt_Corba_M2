package impl;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import bdd.BddJDBC_EL_Autorisation;
import config.Config;
import gui.main;
import modControledAcces.AccesZone;
import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAutorisationHelper;
import modControledAcces.EntiteLogicielleAutorisationPOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogicielleJournalisation;
import modControledAcces.EntiteLogicielleJournalisationHelper;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoSalarieAccreditation;
import modControledAcces.InfoZone;

public class EntiteLogicielleAutorisationImpl extends EntiteLogicielleAutorisationPOA {
	
	public static EntiteLogicielleJournalisation monELJournalisation;
	public static String clePersonnel = "personnel_securite_autorisation";
	public static BddJDBC_EL_Autorisation bddJDBC_EL_Autorisation = new BddJDBC_EL_Autorisation("BD_Autorisation");

	@Override
	public InfoZone[] listeToutesZones() {
		
//		bddJDBC_EL_Autorisation.init();
//		BddJDBC_EL_Autorisation.clearBDD("BD_autorisation");
		InfoZone[] listeZones = bddJDBC_EL_Autorisation.listeZones();
		

		
		return listeZones;
	}

	@Override
	public boolean verifierAutorisation(String idSal, String idZone)
			throws ErreurSalarieInexistant, ErreurZoneInexistant {
		java.util.Date d = new java.util.Date();
		
		return bddJDBC_EL_Autorisation.verifierAutorisation(idSal, idZone, new Timestamp(d.getTime()));
	}

	@Override
	public void creerAccreditation(String idSal, String idZone, Date jourDebut, Date jourFin, 
			Date heureDebut, Date heureFin, String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		if(cleDemandeur.equals(clePersonnel))
		{
			java.util.Date d = new java.util.Date();
			Timestamp tdate = new Timestamp(d.getTime());
			Timestamp tjourDebut = Timestamp.valueOf(jourDebut.timestamp);
			Timestamp tjourFin = Timestamp.valueOf(jourFin.timestamp);
			Timestamp theureDebut = Timestamp.valueOf(heureDebut.timestamp);
			Timestamp theureFin = Timestamp.valueOf(heureFin.timestamp);

			bddJDBC_EL_Autorisation.creerAccrediter(idSal, idZone, tdate, tjourDebut, tjourFin, theureDebut, theureFin);
			connexionELjournalisation(main.param);
			d = new java.util.Date();
			tdate = new Timestamp(d.getTime());
			AccesZone accesZone = new AccesZone(idSal, idZone, true, new Date(tdate.toString()));
			EvenementJournalisation evenementJournalisation = new EvenementJournalisation(accesZone, "creerAccreditation", "jourDebut : "+jourDebut.timestamp+ " jourFin : "+jourFin.timestamp+ 
					" heureDebut : "+heureDebut.timestamp+ " heureFin : "+heureFin.timestamp);
			monELJournalisation.enregistrerEvenement(evenementJournalisation);
		}
		else
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
	}

	@Override
	public InfoSalarieAccreditation lireAccreditationSalarie(String idSal) throws ErreurSalarieInexistant {
		
		InfoSalarieAccreditation infoSalarieAccreditation = bddJDBC_EL_Autorisation.lireAccreditation(idSal);
		
		return infoSalarieAccreditation;
	}

	@Override
	public InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, Date jourDebut, Date jourFin, 
			Date heureDebut, Date heureFin) throws ErreurSalarieInexistant, ErreurZoneInexistant {
		
		Timestamp tjourDebut = Timestamp.valueOf(jourDebut.timestamp);
		Timestamp tjourFin = Timestamp.valueOf(jourFin.timestamp);
		Timestamp theureDebut = Timestamp.valueOf(heureDebut.timestamp);
		Timestamp theureFin = Timestamp.valueOf(heureFin.timestamp);
		
		InfoSalarieAccreditation infoSalarieAccreditation = bddJDBC_EL_Autorisation.modifierAccreditation(idSal, idZone, tjourDebut, tjourFin, theureDebut, theureFin);

		java.util.Date d = new java.util.Date();
		d = new java.util.Date();
		Timestamp tdate = new Timestamp(d.getTime());
		tdate = new Timestamp(d.getTime());
		AccesZone accesZone = new AccesZone(idSal, idZone, true, new Date(tdate.toString()));

		connexionELjournalisation(main.param);
		EvenementJournalisation evenementJournalisation = new EvenementJournalisation(accesZone, "modifierAccreditation", "jourDebut : "+jourDebut.timestamp+ " jourFin : "+jourFin.timestamp+ 
				" heureDebut : "+heureDebut.timestamp+ " heureFin : "+heureFin.timestamp);
		monELJournalisation.enregistrerEvenement(evenementJournalisation);

		return infoSalarieAccreditation;
	}

	@Override
	public InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone) throws ErreurSalarieInexistant, ErreurZoneInexistant {
		
		InfoSalarieAccreditation infoSalarieAccreditation = bddJDBC_EL_Autorisation.supprimerAccreditation(idSal, idZone);
		
		connexionELjournalisation(main.param);
		java.util.Date d = new java.util.Date();
		Timestamp tdate = new Timestamp(d.getTime());
		AccesZone accesZone = new AccesZone(idSal, idZone, true, new Date(tdate.toString()));
		EvenementJournalisation evenementJournalisation = new EvenementJournalisation(accesZone, "supprimerAccreditation","");
		monELJournalisation.enregistrerEvenement(evenementJournalisation);
		
		return infoSalarieAccreditation;
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
