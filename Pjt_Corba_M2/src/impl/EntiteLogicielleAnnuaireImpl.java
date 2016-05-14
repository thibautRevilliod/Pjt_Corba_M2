package impl;

import java.sql.Timestamp;

import bdd.BddJDBC_EL_Annuaire;
import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAnnuairePOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieExistant;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.InfoSalarie;

public class EntiteLogicielleAnnuaireImpl extends EntiteLogicielleAnnuairePOA {
	
	public static BddJDBC_EL_Annuaire bddJDBC_EL_Annuaire = new BddJDBC_EL_Annuaire("BD_Annuaire");
	public static String clePersonnelRh = "personnel_rh_annuaire";
	
	@Override
	public InfoSalarie[] listeTousSalaries() {
		
		return bddJDBC_EL_Annuaire.listeTousSalaries();
	}
	
	@Override
	public InfoSalarie[] listeSalariesTemporaires() {
		
		return bddJDBC_EL_Annuaire.listeSalariesTemporaires();
	}

	@Override
	public String creerSalarie(String mdp, String nom, String prenom, String photo, Date heureDebut, Date heureFin,
			Date jourDebut, Date jourFin, Date dateValiditeCompte, boolean estPermanent) throws ErreurSalarieExistant {
		//TODO: Il manque estPermanent et le type de date ne correspond pas : il faut juste une dateFinValiditeCompte de type Timestamp
		
		String res;
		
		Timestamp tdateValiditeCompte = Timestamp.valueOf(dateValiditeCompte.timestamp);
		
		if(!estPermanent)
		{
			Timestamp tjourDebut = Timestamp.valueOf(jourDebut.timestamp);
			Timestamp tjourFin = Timestamp.valueOf(jourFin.timestamp);
			Timestamp theureDebut = Timestamp.valueOf(heureDebut.timestamp);
			Timestamp theureFin = Timestamp.valueOf(heureFin.timestamp);
			
			res = bddJDBC_EL_Annuaire.creerSalarie(mdp, nom, prenom, photo, theureDebut, theureFin, tjourDebut, tjourFin, tdateValiditeCompte, estPermanent);
		}else
		{
			res = bddJDBC_EL_Annuaire.creerSalarie(mdp, nom, prenom, photo, null, null, null, null, tdateValiditeCompte, estPermanent);
		}
		
		return res;
	}

	@Override
	public String sauthentifier(String photo) throws ErreurSalarieInexistant {
		java.util.Date d = new java.util.Date();
		Timestamp tdate = new Timestamp(d.getTime());
		return bddJDBC_EL_Annuaire.sauthentifier(photo,tdate);
	}

	@Override
	public InfoSalarie recupererNomPhotoSalarie(String idSal, String cleDemandeur)
			throws ErreurSalarieInexistant, CleInconnue {
		if(!cleDemandeur.equals(clePersonnelRh))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Annuaire.infoSalarieNomPhoto(idSal);
	}

	@Override
	public InfoSalarie infosSalarie(String idSal, String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue {
		if(!cleDemandeur.equals(clePersonnelRh))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Annuaire.infoSalarie(idSal);
	}

	

}
