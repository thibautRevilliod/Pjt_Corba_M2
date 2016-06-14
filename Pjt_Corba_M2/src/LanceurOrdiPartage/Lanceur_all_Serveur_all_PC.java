package LanceurOrdiPartage;

public class Lanceur_all_Serveur_all_PC {

	public static void main(String[] args) {
		
		Runnable_all_Serveur_all_PC rannuaire = new Runnable_all_Serveur_all_PC(args, "annuaire");
		Thread trannuaire = new Thread(rannuaire);
		trannuaire.start();
		
		Runnable_all_Serveur_all_PC rautorisation = new Runnable_all_Serveur_all_PC(args, "autorisation");
		Thread trautorisation = new Thread(rautorisation);
		trautorisation.start();

		Runnable_all_Serveur_all_PC rempreinte = new Runnable_all_Serveur_all_PC(args, "empreinte");
		Thread trempreinte = new Thread(rempreinte);
		trempreinte.start();
		
		Runnable_all_Serveur_all_PC rjournalisation = new Runnable_all_Serveur_all_PC(args, "journalisation");
		Thread trjournalisation = new Thread(rjournalisation);
		trjournalisation.start();
		
		Runnable_all_Serveur_all_PC rporte = new Runnable_all_Serveur_all_PC(args, "porte");
		Thread trporte = new Thread(rporte);
		trporte.start();

	}

}