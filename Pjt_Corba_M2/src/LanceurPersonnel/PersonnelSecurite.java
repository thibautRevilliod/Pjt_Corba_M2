package LanceurPersonnel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import config.Config;
import modControledAcces.*;

public class PersonnelSecurite {
	
	public static EntiteLogicielleAutorisation monELAutorisation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);




	        // Saisie du nom de l'objet (si utilisation du service de nommage)
	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();

	        // Recuperation du naming service
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

	        // Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantELAutorisation = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantELAutorisation));
	        Config.IOR_EL_Autorisation = orb.object_to_string(distantELAutorisation);

	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
//	        org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001B49444C3A436F6E766572746973736575722F4575726F3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E31000012A000000014004F4F01A72446DC50010000504F41FE7703957F00000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro

	        monELAutorisation = EntiteLogicielleAutorisationHelper.narrow(distantELAutorisation);

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);
	        
	        monELAutorisation.listeToutesZones();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
