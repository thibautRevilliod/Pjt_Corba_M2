package impl;

import modControledAcces.Date;
import modControledAcces.EntiteLogicielleAnnuairePOA;
import modControledAcces.EntiteLogicielleEmpreinte;
import modControledAcces.EntiteLogiciellePorte;
import modControledAcces.ErreurSalarieExistant;
import modControledAcces.ErreurSalarieInexistant;
import modControledAcces.InfoSalarie;

public class EntiteLogicielleAnnuaireImpl extends EntiteLogicielleAnnuairePOA {
	
	@Override
	public InfoSalarie[] listeTousSalaries() {
		
		InfoSalarie infoSalarie = new InfoSalarie();
		InfoSalarie[] listeSalaries = {infoSalarie};
		
		System.out.println("test !!!!!");
		return listeSalaries;
	}

	@Override
	public InfoSalarie recupererNomPhotoSalarie(String idSal, EntiteLogicielleEmpreinte el_Empreinte)
			throws ErreurSalarieInexistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoSalarie infosSalarie(String idSal, EntiteLogicielleEmpreinte el_Empreinte)
			throws ErreurSalarieInexistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creerSalarie(String mdp, String nom, String prenom, String photo, Date heureDebut, Date heureFin,
			Date jourDebut, Date jourFin, short dureeValidationCompte) throws ErreurSalarieExistant {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sauthentifier(String photo, EntiteLogiciellePorte el_Porte) throws ErreurSalarieInexistant {
		// TODO Auto-generated method stub
		return null;
	}

}
