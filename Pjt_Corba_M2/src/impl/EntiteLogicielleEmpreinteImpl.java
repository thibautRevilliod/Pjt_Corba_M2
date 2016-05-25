package impl;

import bdd.BddJDBC_EL_Empreinte;
import bdd.BddJDBC_EL_Autorisation;
import modControledAcces.CleInconnue;
import modControledAcces.Date;
import modControledAcces.EmpreinteExistante;
import modControledAcces.EmpreinteIncorrecte;
import modControledAcces.EntiteLogicielleEmpreintePOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieExistant;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.InfoSalarie;

public class EntiteLogicielleEmpreinteImpl extends EntiteLogicielleEmpreintePOA {
	
	public static BddJDBC_EL_Empreinte bddJDBC_EL_Empreinte = new BddJDBC_EL_Empreinte("BD_Empreinte");
	public static String clePersonnelRh = "personnel_rh_annuaire";
	public static String cleEmpreinte = "personnel_rh_empreinte"; 


	@Override
	public String ajouterEmpreinte(String idSal, String empreinte, String cleDemandeur)
			throws EmpreinteExistante, CleInconnue, EmpreinteIncorrecte {
		if(!cleDemandeur.equals(cleEmpreinte))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Empreinte.ajouterEmpreinte(idSal, empreinte);
		
	}

	@Override
	public String modifierEmpreinte(String idSal, String empreinte, String cleDemandeur)
			throws EmpreinteExistante, CleInconnue, EmpreinteIncorrecte {
		if(!cleDemandeur.equals(clePersonnelRh))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Empreinte.modifierEmpreinte(idSal, empreinte);
		
	}
	
	//TODO à supprimer
	@Override
	public String getCorrespondance(String empreinte, String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue {
		if(!cleDemandeur.equals(clePersonnelRh))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}		
		return bddJDBC_EL_Empreinte.getCorrespondance(empreinte);
		
	}

	@Override
	public boolean verifierCorrespondance(String idSal, String empreinte, String cleDemandeur)
			throws ErreurSalarieInexistant, CleInconnue, EmpreinteIncorrecte {
		if((!cleDemandeur.equals(clePersonnelRh)) && (!cleDemandeur.equals(cleEmpreinte)))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Empreinte.verifierCorrespondance(idSal, empreinte);
		
	}

	@Override
	public String supprimerEmpreinte(String idSal, String cleDemandeur) throws ErreurSalarieInexistant, CleInconnue {
		if(!cleDemandeur.equals(cleEmpreinte))
		{
			throw new CleInconnue("La clé demandeur n'est pas valide");
		}
		return bddJDBC_EL_Empreinte.supprimerEmpreinte(idSal);
		
	}
	

}
