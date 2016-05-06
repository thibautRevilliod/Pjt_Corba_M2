package impl;

import bdd.BddJDBC_EL_Annuaire;
import bdd.BddJDBC_EL_Autorisation;
import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAnnuairePOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieExistant;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.InfoSalarie;

public class EntiteLogicielleAnnuaireImpl extends EntiteLogicielleAnnuairePOA {
	
	public static BddJDBC_EL_Annuaire bddJDBC_EL_Annuaire = new BddJDBC_EL_Annuaire("BD_Annuaire");
	
	@Override
	public InfoSalarie[] listeTousSalaries() {
		
		return bddJDBC_EL_Annuaire.listeTousSalaries();
	}

	@Override
	public InfoSalarie recupererNomPhotoSalarie(String idSal, EntiteLogicielleEmpreinte el_Empreinte)
			throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.infoSalarieNomPhoto(idSal);
	}

	@Override
	public InfoSalarie infosSalarie(String idSal, EntiteLogicielleEmpreinte el_Empreinte)
			throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.infoSalarie(idSal);
	}

	@Override
	public String creerSalarie(String mdp, String nom, String prenom, String photo, Date heureDebut, Date heureFin,
			Date jourDebut, Date jourFin, short dureeValidationCompte) throws ErreurSalarieExistant {
		//TODO: Il manque estPermanent et le type de date ne correspond pas : il faut juste une dateFinValiditeCompte de type Timestamp
		return bddJDBC_EL_Annuaire.creerSalarie(mdp, nom, prenom, photo, heureDebut, heureFin, jourDebut, jourFin, dureeValidationCompte);
	}

	@Override
	public String sauthentifier(String photo, EntiteLogiciellePorte el_Porte) throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.sauthentifier(photo);
	}

}
