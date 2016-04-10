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
    public String[] listeToutesZones();

    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation creerAccreditation
     */
    public void creerAccreditation(String idSal, String idZone, modControledAcces.Date dateAccessDebut, modControledAcces.Date dateAccessFin, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation lireAccreditationSalarie
     */
    public modControledAcces.InfoSalarieAccreditation lireAccreditationSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant;

    /**
     * Operation modifierAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

    /**
     * Operation supprimerAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant;

}
