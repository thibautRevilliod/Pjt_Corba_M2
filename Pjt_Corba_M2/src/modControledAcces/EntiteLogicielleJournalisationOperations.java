package modControledAcces;

/**
 * Interface definition : EntiteLogicielleJournalisation
 * 
 * @author OpenORB Compiler
 */
public interface EntiteLogicielleJournalisationOperations
{
    /**
     * Operation consulter
     */
    public modControledAcces.EvenementJournalisation consulter(String qui, String quoi, String quand_debut, String quand_fin);

    /**
     * Operation enregistrerEvenement
     */
    public void enregistrerEvenement(modControledAcces.EvenementJournalisation evenementJournalisation);

}
