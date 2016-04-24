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
    public void demandeEntrerSortirZone(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte);

    /**
     * Operation demanderAuthentifier
     */
    public void demanderAuthentifier(String photo, modControledAcces.EntiteLogiciellePorte el_Porte);

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte, modControledAcces.EntiteLogiciellePorte el_Porte);

}
