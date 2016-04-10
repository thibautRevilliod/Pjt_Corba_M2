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
    public void ajouterEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String idSal, String empreinte, modControledAcces.EntiteLogiciellePorte el_Porte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation getCorrespondance
     */
    public String getCorrespondance(String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue;

    /**
     * Operation verifierCorrespondance
     */
    public void verifierCorrespondance(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte;

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue;

}
