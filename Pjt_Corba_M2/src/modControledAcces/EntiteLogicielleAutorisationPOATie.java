package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAutorisation
 * 
 * @author OpenORB Compiler
 */
public class EntiteLogicielleAutorisationPOATie extends EntiteLogicielleAutorisationPOA
{

    //
    // Private reference to implementation object
    //
    private EntiteLogicielleAutorisationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EntiteLogicielleAutorisationPOATie(EntiteLogicielleAutorisationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EntiteLogicielleAutorisationPOATie(EntiteLogicielleAutorisationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EntiteLogicielleAutorisationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EntiteLogicielleAutorisationOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation listeToutesZones
     */
    public String[] listeToutesZones()
    {
        return _tie.listeToutesZones();
    }

    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        return _tie.verifierAutorisation( idSal,  idZone,  el_Porte);
    }

    /**
     * Operation creerAccreditation
     */
    public void creerAccreditation(String idSal, String idZone, modControledAcces.Date dateAccessDebut, modControledAcces.Date dateAccessFin, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.ErreurZoneInexistant
    {
        _tie.creerAccreditation( idSal,  idZone,  dateAccessDebut,  dateAccessFin,  cleDemandeur);
    }

    /**
     * Operation lireAccreditationSalarie
     */
    public modControledAcces.InfoSalarieAccreditation lireAccreditationSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant
    {
        return _tie.lireAccreditationSalarie( idSal);
    }

    /**
     * Operation modifierAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        return _tie.modifierAccreditation( idSal,  idZone,  el_Empreinte);
    }

    /**
     * Operation supprimerAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        return _tie.supprimerAccreditation( idSal,  idZone,  el_Empreinte);
    }

}
