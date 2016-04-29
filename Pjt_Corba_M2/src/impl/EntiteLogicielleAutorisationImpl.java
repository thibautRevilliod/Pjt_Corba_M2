package impl;

import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAutorisationPOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.ErreurZoneInexistant;
import modControledAcces.InfoSalarieAccreditation;

public class EntiteLogicielleAutorisationImpl extends EntiteLogicielleAutorisationPOA {

	@Override
	public String[] listeToutesZones() {
		// TODO Auto-generated method stub
		
		String tabTemp[] = {"une valeur"};
		
		System.out.println("test !!!!!");
		return tabTemp;
	}

	@Override
	public boolean verifierAutorisation(String idSal, String idZone, EntiteLogiciellePorte el_Porte)
			throws ErreurSalarieInexistant, ErreurZoneInexistant {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creerAccreditation(String idSal, String idZone, Date dateAccessDebut, Date dateAccessFin,
			String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue, ErreurZoneInexistant {
		// TODO Auto-generated method stub
	}

	@Override
	public InfoSalarieAccreditation lireAccreditationSalarie(String idSal) throws ErreurSalarieInexistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone,
			EntiteLogicielleEmpreinte el_Empreinte) throws ErreurSalarieInexistant, ErreurZoneInexistant {
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
