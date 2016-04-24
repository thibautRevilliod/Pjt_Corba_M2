package LanceurPersonnel;

import modControledAcces.*;

public class PersonnelSecurite {
	
	public static EntiteLogicielleAutorisation monELAutorisation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);


	/*

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
	        org.omg.CORBA.Object distantEuro = nameRoot.resolve(nameToFind);
	        System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
	        System.out.println(orb.object_to_string(distantEuro));
	*/
	        // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
	        org.omg.CORBA.Object distantELAutorisation = orb.string_to_object("IOR:000000000000003749444C3A6D6F64436F6E74726F6C656441636365732F456E746974654C6F67696369656C6C654175746F7269736174696F6E3A312E300000000000010000000000000060000102000000000D3139322E3136382E35362E310000D89000000014004F4F01E4AAC64854010000504F41FE20895CB200000001000000010000002400000000100204E4000000030001000F0001000100010020000101090000000100010100");
	        // Casting de l'objet CORBA au type convertisseur euro
	        monELAutorisation = EntiteLogicielleAutorisationHelper.narrow(distantELAutorisation);
	        
//	        monELAutorisation.creerAccreditation("aaa","aaaa",new Date(),new Date(),"aaaa");
	        monELAutorisation.listeToutesZones();

	        // Appel de l'interface graphique
//	        JFrame frame = new InterfaceFrame();
//	        frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
