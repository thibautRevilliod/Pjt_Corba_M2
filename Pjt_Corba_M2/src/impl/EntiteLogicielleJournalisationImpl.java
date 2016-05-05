package impl;

import bdd.BddJDBC_EL_Autorisation;
import bdd.BddJDBC_EL_Journalisation;
import modControledAcces.CleInconnue;

import modControledAcces.EntiteLogicielleJournalisationPOA;

import modControledAcces.EvenementJournalisation;


public class EntiteLogicielleJournalisationImpl extends EntiteLogicielleJournalisationPOA {
	
	public static BddJDBC_EL_Journalisation bddJDBC_EL_Journalisation = new BddJDBC_EL_Journalisation("BD_Journalisation");
	
	@Override
	public EvenementJournalisation consulter(String qui, String quoi, String quand_debut, String quand_fin,
			String cleDemandeur) throws CleInconnue {
		// TODO Auto-generated method stub
		
		EvenementJournalisation evenementJournalisation = bddJDBC_EL_Journalisation.consulter(qui, 
				quoi, quand_debut,  quand_fin);
		
		return evenementJournalisation;
	}

	@Override
	public void enregistrerEvenement(EvenementJournalisation evenementJournalisation) {
		// TODO Auto-generated method stub 
		
		bddJDBC_EL_Journalisation.enregistrerEvenement(evenementJournalisation);
	}

}
