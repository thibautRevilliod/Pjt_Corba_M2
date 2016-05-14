package modControledAcces;

/**
 * Interface definition : EntiteLogicielleEmpreinte
 * 
 * @author OpenORB Compiler
 */
public interface EntiteLogicielleEmpreinteOperations
{
    /**
     * Operation ajouterEmpreinte
     */
    public String ajouterEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation modifierEmpreinte
     */
    public String modifierEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation getCorrespondance
     */
    public String getCorrespondance(String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue;

    /**
     * Operation verifierCorrespondance
     */
    public boolean verifierCorrespondance(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation supprimerEmpreinte
     */
    public String supprimerEmpreinte(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue;

}
