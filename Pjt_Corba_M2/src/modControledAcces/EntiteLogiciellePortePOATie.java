package modControledAcces;

/**
 * Interface definition : EntiteLogiciellePorte
 * 
 * @author OpenORB Compiler
 */
public class EntiteLogiciellePortePOATie extends EntiteLogiciellePortePOA
{

    //
    // Private reference to implementation object
    //
    private EntiteLogiciellePorteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EntiteLogiciellePortePOATie(EntiteLogiciellePorteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EntiteLogiciellePortePOATie(EntiteLogiciellePorteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EntiteLogiciellePorteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EntiteLogiciellePorteOperations delegate_)
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
     * Operation afficherMessage
     */
    public void afficherMessage()
    {
        _tie.afficherMessage();
    }

    /**
     * Operation demandeEntrerSortirZone
     */
    public void demandeEntrerSortirZone(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
    {
        _tie.demandeEntrerSortirZone( idSal,  idZone,  el_Porte);
    }

    /**
     * Operation demanderAuthentifier
     */
    public void demanderAuthentifier(String photo, modControledAcces.EntiteLogiciellePorte el_Porte)
    {
        _tie.demanderAuthentifier( photo,  el_Porte);
    }

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte, modControledAcces.EntiteLogiciellePorte el_Porte)
    {
        _tie.demanderModifierEmpreinte( idSal,  empreinte,  el_Porte);
    }

}
