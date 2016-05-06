package impl;

import java.sql.Timestamp;

import bdd.BddJDBC_EL_Journalisation;
import modControledAcces.CleInconnue;

import modControledAcces.EntiteLogicielleJournalisationPOA;

import modControledAcces.EvenementJournalisation;


public class EntiteLogicielleJournalisationImpl extends EntiteLogicielleJournalisationPOA {
	
	public static BddJDBC_EL_Journalisation bddJDBC_EL_Journalisation = new BddJDBC_EL_Journalisation("BD_Journalisation");
	
	@Override
	public EvenementJournalisation[] consulter(String qui, String quoi, String quand_debut, String quand_fin,
			String cleDemandeur) throws CleInconnue {
	
		
		Timestamp tquand_debut = new Timestamp(Long.valueOf(quand_debut));
		Timestamp tquand_fin = new Timestamp(Long.valueOf(quand_fin));
		
		
		EvenementJournalisation[] evenementJournalisation = bddJDBC_EL_Journalisation.consulterEvenement(qui, quoi, tquand_debut, tquand_fin);
		
		//TODO : Erreur dans l'IDL => faut retourner un tableau non ?? car il peut y avoir plusieurs évènements
		return evenementJournalisation;
	}

	@Override
	public void enregistrerEvenement(EvenementJournalisation evenementJournalisation) {
		// TODO : il faut tranformer evenementJournalisation.accesZoneSal.jourHeure en type TimesTamp pour le passer en paramètre de la méthode : comment fait-on pour le transformer ? :: OK
		
		Timestamp tjourHeure = new Timestamp(Long.valueOf(evenementJournalisation.accesZoneSal.jourHeure.timestamp));
		
		bddJDBC_EL_Journalisation.enregistrerEvenement(evenementJournalisation.accesZoneSal.idSal, evenementJournalisation.accesZoneSal.idZone, evenementJournalisation.accesZoneSal.statutAcces, tjourHeure, evenementJournalisation.operation, evenementJournalisation.contenuOperation);
	}

}
