package config;

public class Lanceur_jour_por {

	public static void main(String[] args) {
		
		Runnable_all_Serveur rjournalisation = new Runnable_all_Serveur(args, "journalisation");
		Thread trjournalisation = new Thread(rjournalisation);
		trjournalisation.start();
		
		Runnable_all_Serveur rporte = new Runnable_all_Serveur(args, "porte");
		Thread trporte = new Thread(rporte);
		trporte.start();

	}

}