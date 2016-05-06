package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAnnuaire
 * 
 * @author OpenORB Compiler
 */
public interface EntiteLogicielleAnnuaireOperations
{
    /**
     * Operation listeTousSalaries
     */
    public modControledAcces.InfoSalarie[] listeTousSalaries();

    /**
     * Operation recupererNomPhotoSalarie
     */
    public modControledAcces.InfoSalarie recupererNomPhotoSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant;

    /**
     * Operation infosSalarie
     */
    public modControledAcces.InfoSalarie infosSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant;

    /**
     * Operation creerSalarie
     */
    public String creerSalarie(String mdp, String nom, String prenom, String photo, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date dateFinValiditeCompte, boolean estPermanent)
        throws modControledAcces.ErreurSalarieExistant;

    /**
     * Operation sauthentifier
     */
    public String sauthentifier(String photo)
        throws modControledAcces.ErreurSalarieInexistant;

}
