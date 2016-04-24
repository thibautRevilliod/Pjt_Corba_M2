package LanceurEntiteLogicielle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

import impl.EntiteLogicielleAutorisationImpl;

public class EntiteLogicielleAutorisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Intialisation de l'ORB
	        //************************
	        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

	        // Gestion du POA
	        //****************
	        // Recuperation du POA
	        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

	        // Creation du servant
	        //*********************
	        EntiteLogicielleAutorisationImpl monAutorisation = new EntiteLogicielleAutorisationImpl();

	        // Activer le servant au sein du POA et recuperer son ID
	        byte[] monEuroId = rootPOA.activate_object(monAutorisation);

	        // Activer le POA manager
	        rootPOA.the_POAManager().activate();
	        
	        String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monAutorisation));
	        System.out.println("L'objet possede la reference suivante :");
	        System.out.println(IORServant);

	        // Lancement de l'ORB et mise en attente de requete
	        //**************************************************
	        orb.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
