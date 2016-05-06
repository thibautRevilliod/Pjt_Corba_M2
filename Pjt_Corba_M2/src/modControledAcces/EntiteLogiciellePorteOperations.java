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
    public void demandeEntrerSortirZone(String idSal, String idZone);

    /**
     * Operation demanderAuthentifier
     */
    public void demanderAuthentifier(String photo);

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte);

}
