package impl;

import bdd.BddJDBC_EL_Autorisation;
import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAutorisationPOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.InfoSalarieAccreditation;
import modControledAcces.InfoZone;

public class EntiteLogicielleAutorisationImpl extends EntiteLogicielleAutorisationPOA {
	
	public static String clePersonnel = "personnel_securite";
	public static BddJDBC_EL_Autorisation bddJDBC_EL_Autorisation = new BddJDBC_EL_Autorisation("BD_autorisation");

	@Override
	public InfoZone[] listeToutesZones() {
		
		bddJDBC_EL_Autorisation.init();
//		BddJDBC_EL_Autorisation.clearBDD("BD_autorisation");
		InfoZone[] listeZones = bddJDBC_EL_Autorisation.listeZones();
		
		
		System.out.println("test !!!!!");
		
		try {
			bddJDBC_EL_Autorisation.fermer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeZones;
	}

	@Override
	public boolean verifierAutorisation(String idSal, String idZone, EntiteLogiciellePorte el_Porte)
			throws ErreurSalarieInexistant, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creerAccreditation(String idSal, String idZone, Date jourDebut, Date jourFin, 
			Date heureDebut, Date heureFin, String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		if(cleDemandeur.equals(clePersonnel))
		{
			
		}
		else
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
	}

	@Override
	public InfoSalarieAccreditation lireAccreditationSalarie(String idSal) throws ErreurSalarieInexistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, Date jourDebut, Date jourFin, 
			Date heureDebut, Date heureFin, EntiteLogicielleEmpreinte el_Empreinte) throws ErreurSalarieInexistant, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone,
			EntiteLogicielleEmpreinte el_Empreinte) throws ErreurSalarieInexistant, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		return null;
	}

}
