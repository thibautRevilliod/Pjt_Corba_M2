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
    public String demanderAuthentifier(String photo, String empreinte);

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte);

}
