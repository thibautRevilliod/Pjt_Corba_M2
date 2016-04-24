package modControledAcces;

/**
 * Interface definition : EntiteLogicielleEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class EntiteLogicielleEmpreintePOATie extends EntiteLogicielleEmpreintePOA
{

    //
    // Private reference to implementation object
    //
    private EntiteLogicielleEmpreinteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EntiteLogicielleEmpreintePOATie(EntiteLogicielleEmpreinteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EntiteLogicielleEmpreintePOATie(EntiteLogicielleEmpreinteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EntiteLogicielleEmpreinteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EntiteLogicielleEmpreinteOperations delegate_)
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
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        _tie.ajouterEmpreinte( idSal,  empreinte,  cleDemandeur);
    }

    /**
     * Operation modifierEmpreinte
     */
    public String modifierEmpreinte(String idSal, String empreinte, modControledAcces.EntiteLogiciellePorte el_Porte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        return _tie.modifierEmpreinte( idSal,  empreinte,  el_Porte,  cleDemandeur);
    }

    /**
     * Operation getCorrespondance
     */
    public String getCorrespondance(String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        return _tie.getCorrespondance( empreinte,  cleDemandeur);
    }

    /**
     * Operation verifierCorrespondance
     */
    public boolean verifierCorrespondance(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        return _tie.verifierCorrespondance( idSal,  empreinte,  cleDemandeur);
    }

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        _tie.supprimerEmpreinte( idSal,  cleDemandeur);
    }

}
