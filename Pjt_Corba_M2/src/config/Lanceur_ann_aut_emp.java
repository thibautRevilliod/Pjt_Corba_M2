package config;

public class Lanceur_ann_aut_emp {

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
		
	}

}