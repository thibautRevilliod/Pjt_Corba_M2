package config;

public class Lanceur_all_Serveur {

	public static void main(String[] args) {
		
		Runnable_all_Serveur rannuaire = new Runnable_all_Serveur(args, "annuaire");
		Thread trannuaire = new Thread(rannuaire);
		trannuaire.start();
		
		Runnable_all_Serveur rautorisation = new Runnable_all_Serveur(args, "autorisation");
		Thread trautorisation = new Thread(rautorisation);
		trautorisation.start();

		Runnable_all_Serveur rempreinte = new Runnable_all_Serveur(args, "empreinte");
		Thread trempreinte = new Thread(rempreinte);
		trempreinte.start();
		
		Runnable_all_Serveur rjournalisation = new Runnable_all_Serveur(args, "journalisation");
		Thread trjournalisation = new Thread(rjournalisation);
		trjournalisation.start();
		
		Runnable_all_Serveur rporte = new Runnable_all_Serveur(args, "porte");
		Thread trporte = new Thread(rporte);
		trporte.start();

	}

}