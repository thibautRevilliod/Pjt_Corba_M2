package modControledAcces;

/**
 * Interface definition : EntiteLogiciellePorte
 * 
 * @author OpenORB Compiler
 */
public interface EntiteLogiciellePorteOperations
{
    /**
     * Operation afficherMessage
     */
    public void afficherMessage();

    /**
     * Operation demandeEntrerSortirZone
     */
    public boolean demandeEntrerSortirZone(String idSal, String idZone);

    /**
     * Operation demanderAuthentifier
     */
    public String demanderAuthentifier(String photo, String empreinte);

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte);

    /**
     * Operation creerPorte
     */
    public String creerPorte(String libellePorte, String idZone)
        throws modControledAcces.ErreurPorteExistant;

}
