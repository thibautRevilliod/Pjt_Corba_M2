package impl;

import java.sql.Timestamp;

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
	public InfoSalarie recupererNomPhotoSalarie(String idSal)
			throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.infoSalarieNomPhoto(idSal);
	}

	@Override
	public InfoSalarie infosSalarie(String idSal)
			throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.infoSalarie(idSal);
	}

	@Override
	public String creerSalarie(String mdp, String nom, String prenom, String photo, Date heureDebut, Date heureFin,
			Date jourDebut, Date jourFin, Date dateValiditeCompte, boolean estPermanent) throws ErreurSalarieExistant {
		//TODO: Il manque estPermanent et le type de date ne correspond pas : il faut juste une dateFinValiditeCompte de type Timestamp

		Timestamp tjourDebut = new Timestamp(Long.valueOf(jourDebut.timestamp));
		Timestamp tjourFin = new Timestamp(Long.valueOf(jourFin.timestamp));
		Timestamp theureDebut = new Timestamp(Long.valueOf(heureDebut.timestamp));
		Timestamp theureFin = new Timestamp(Long.valueOf(heureFin.timestamp));
		Timestamp tdateValiditeCompte = new Timestamp(Long.valueOf(dateValiditeCompte.timestamp));
		
		return bddJDBC_EL_Annuaire.creerSalarie(mdp, nom, prenom, photo, theureDebut, theureFin, tjourDebut, tjourFin, tdateValiditeCompte, estPermanent);
	}

	@Override
	public String sauthentifier(String photo) throws ErreurSalarieInexistant {
		
		return bddJDBC_EL_Annuaire.sauthentifier(photo);
	}

}
