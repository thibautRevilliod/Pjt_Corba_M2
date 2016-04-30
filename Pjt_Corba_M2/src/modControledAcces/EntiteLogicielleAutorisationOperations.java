package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAutorisation
 * 
 * @author OpenORB Compiler
 */
public interface EntiteLogicielleAutorisationOperations
{
    /**
     * Operation listeToutesZones
     */
    public modControledAcces.InfoZone[] listeToutesZones();

    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation creerAccreditation
     */
    public void creerAccreditation(String idSal, String idZone, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation lireAccreditationSalarie
     */
    public modControledAcces.InfoSalarieAccreditation lireAccreditationSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant;

    /**
     * Operation modifierAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation supprimerAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

}
