package modControledAcces;

/**
 * Interface definition : EntiteLogicielleJournalisation
 * 
 * @author OpenORB Compiler
 */
public class EntiteLogicielleJournalisationPOATie extends EntiteLogicielleJournalisationPOA
{

    //
    // Private reference to implementation object
    //
    private EntiteLogicielleJournalisationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EntiteLogicielleJournalisationPOATie(EntiteLogicielleJournalisationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EntiteLogicielleJournalisationPOATie(EntiteLogicielleJournalisationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EntiteLogicielleJournalisationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EntiteLogicielleJournalisationOperations delegate_)
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
     * Operation consulter
     */
    public modControledAcces.EvenementJournalisation[] consulter(String qui, String quoi, String quand_debut, String quand_fin, String cleDemandeur)
        throws modControledAcces.CleInconnue
    {
        return _tie.consulter( qui,  quoi,  quand_debut,  quand_fin,  cleDemandeur);
    }

    /**
     * Operation enregistrerEvenement
     */
    public void enregistrerEvenement(modControledAcces.EvenementJournalisation evenementJournalisation)
    {
        _tie.enregistrerEvenement( evenementJournalisation);
    }

}
