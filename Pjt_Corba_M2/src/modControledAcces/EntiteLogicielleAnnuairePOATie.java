package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAnnuaire
 * 
 * @author OpenORB Compiler
 */
public class EntiteLogicielleAnnuairePOATie extends EntiteLogicielleAnnuairePOA
{

    //
    // Private reference to implementation object
    //
    private EntiteLogicielleAnnuaireOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EntiteLogicielleAnnuairePOATie(EntiteLogicielleAnnuaireOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EntiteLogicielleAnnuairePOATie(EntiteLogicielleAnnuaireOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EntiteLogicielleAnnuaireOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EntiteLogicielleAnnuaireOperations delegate_)
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
     * Operation listeTousSalaries
     */
    public modControledAcces.InfoSalarie[] listeTousSalaries()
    {
        return _tie.listeTousSalaries();
    }

    /**
     * Operation listeSalariesTemporaires
     */
    public modControledAcces.InfoSalarie[] listeSalariesTemporaires()
    {
        return _tie.listeSalariesTemporaires();
    }

    /**
     * Operation recupererNomPhotoSalarie
     */
    public modControledAcces.InfoSalarie recupererNomPhotoSalarie(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        return _tie.recupererNomPhotoSalarie( idSal,  cleDemandeur);
    }

    /**
     * Operation infosSalarie
     */
    public modControledAcces.InfoSalarie infosSalarie(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        return _tie.infosSalarie( idSal,  cleDemandeur);
    }

    /**
     * Operation creerSalarie
     */
    public String creerSalarie(String mdp, String nom, String prenom, String photo, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date dateFinValiditeCompte, boolean estPermanent)
        throws modControledAcces.ErreurSalarieExistant
    {
        return _tie.creerSalarie( mdp,  nom,  prenom,  photo,  heureDebut,  heureFin,  jourDebut,  jourFin,  dateFinValiditeCompte,  estPermanent);
    }

    /**
     * Operation sauthentifier
     */
    public String sauthentifier(String photo)
        throws modControledAcces.ErreurSalarieInexistant
    {
        return _tie.sauthentifier( photo);
    }

}
