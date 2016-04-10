package modControledAcces;

/**
 * Struct definition : EvenementJournalisation
 * 
 * @author OpenORB Compiler
*/
public final class EvenementJournalisation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member accesZoneSal
     */
    public modControledAcces.AccesZone accesZoneSal;

    /**
     * Struct member operation
     */
    public String operation;

    /**
     * Struct member contenuOperation
     */
    public String contenuOperation;

    /**
     * Default constructor
     */
    public EvenementJournalisation()
    { }

    /**
     * Constructor with fields initialization
     * @param accesZoneSal accesZoneSal struct member
     * @param operation operation struct member
     * @param contenuOperation contenuOperation struct member
     */
    public EvenementJournalisation(modControledAcces.AccesZone accesZoneSal, String operation, String contenuOperation)
    {
        this.accesZoneSal = accesZoneSal;
        this.operation = operation;
        this.contenuOperation = contenuOperation;
    }

}
