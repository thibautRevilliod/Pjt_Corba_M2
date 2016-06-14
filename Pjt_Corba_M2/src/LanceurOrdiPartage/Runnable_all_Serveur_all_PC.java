package LanceurOrdiPartage;

import LanceurOrdiPartage.LanceurEntiteLogicielleAnnuaire;
import LanceurOrdiPartage.LanceurEntiteLogicielleAutorisation;
import LanceurOrdiPartage.LanceurEntiteLogicielleEmpreinte;
import LanceurOrdiPartage.LanceurEntiteLogicielleJournalisation;
import LanceurOrdiPartage.LanceurEntiteLogiciellePorte;

public class Runnable_all_Serveur_all_PC implements Runnable {
	//TODO : pour simplifier les tests; les methodes sont de type public
	private String[] args;
	private String nomServeur;
	
	public Runnable_all_Serveur_all_PC(String[] _args, String _nomServeur){
		this.args = _args;
		this.nomServeur = _nomServeur;
	}

	private void autorisation(String[] args){
		LanceurEntiteLogicielleAutorisation lanceurEntiteLogicielleAutorisation = new LanceurEntiteLogicielleAutorisation();
		lanceurEntiteLogicielleAutorisation.enregistrementNS(args);
	}
	
	private void annuaire(String[] args){
		LanceurEntiteLogicielleAnnuaire lanceurEntiteLogicielleAnnuaire = new LanceurEntiteLogicielleAnnuaire();
		lanceurEntiteLogicielleAnnuaire.enregistrementNS(args);
	}
	
	private void empreinte(String[] args){
		LanceurEntiteLogicielleEmpreinte lanceurEntiteLogicielleEmpreinte = new LanceurEntiteLogicielleEmpreinte();
		lanceurEntiteLogicielleEmpreinte.enregistrementNS(args);
	}
	
	private void journalisation(String[] args){
		LanceurEntiteLogicielleJournalisation lanceurEntiteLogicielleJournalisation = new LanceurEntiteLogicielleJournalisation();
		lanceurEntiteLogicielleJournalisation.enregistrementNS(args);
	}
	
	private void porte(String[] args){
		LanceurEntiteLogiciellePorte lanceurEntiteLogiciellePorte = new LanceurEntiteLogiciellePorte();
		lanceurEntiteLogiciellePorte.enregistrementNS(args);
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch(this.nomServeur)
		{
		case "autorisation":
				this.autorisation(this.args);
				break;
		case "annuaire":
			this.annuaire(this.args);
			break;
		case "empreinte":
			this.empreinte(this.args);
			break;
		case "journalisation":
			this.journalisation(this.args);
			break;
		case "porte":
			this.porte(this.args);
			break;
		}
		
	}

}