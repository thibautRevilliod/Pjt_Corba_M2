package impl;

import java.sql.Timestamp;

import bdd.BddJDBC_EL_Journalisation;
import modControledAcces.CleInconnue;

import modControledAcces.EntiteLogicielleJournalisationPOA;

import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoOperation;


public class EntiteLogicielleJournalisationImpl extends EntiteLogicielleJournalisationPOA {
	
	public static BddJDBC_EL_Journalisation bddJDBC_EL_Journalisation = new BddJDBC_EL_Journalisation("BD_Journalisation");
	public static String clePersonnelSecuriteAutorisation = "personnel_securite_autorisation";
	public static String clePersonnelSecuriteJournalisation = "personnel_securite_journalisation";
	
	@Override
	public EvenementJournalisation[] consulter(String qui, String quoi, String quand_debut, String quand_fin,
			String cleDemandeur) throws CleInconnue {
	
		if((!cleDemandeur.equals(clePersonnelSecuriteAutorisation)) && (!cleDemandeur.equals(clePersonnelSecuriteJournalisation)))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		
		Timestamp tquand_debut = Timestamp.valueOf(quand_debut);
		Timestamp tquand_fin = Timestamp.valueOf(quand_fin);
		
		
		EvenementJournalisation[] evenementJournalisation = bddJDBC_EL_Journalisation.consulterEvenement(qui, quoi, tquand_debut, tquand_fin);
		
		return evenementJournalisation;
	}

	@Override
	public void enregistrerEvenement(EvenementJournalisation evenementJournalisation) {
		
		Timestamp tjourHeure = Timestamp.valueOf(evenementJournalisation.accesZoneSal.jourHeure.timestamp);
		
		bddJDBC_EL_Journalisation.enregistrerEvenement(evenementJournalisation.accesZoneSal.idSal, evenementJournalisation.accesZoneSal.idZone, evenementJournalisation.accesZoneSal.statutAcces, tjourHeure, evenementJournalisation.operation, evenementJournalisation.contenuOperation);
	}

	@Override
	public InfoOperation[] listeOperations() {
		// TODO Auto-generated method stub
		
		InfoOperation[] infoOperation = bddJDBC_EL_Journalisation.listeOperations();

		return infoOperation;
	}

}
