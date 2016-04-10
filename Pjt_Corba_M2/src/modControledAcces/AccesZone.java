package modControledAcces;

/**
 * Struct definition : AccesZone
 * 
 * @author OpenORB Compiler
*/
public final class AccesZone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idSal
     */
    public String idSal;

    /**
     * Struct member idZone
     */
    public String idZone;

    /**
     * Struct member dateDdeAcces
     */
    public modControledAcces.Date dateDdeAcces;

    /**
     * Struct member statutAcces
     */
    public boolean statutAcces;

    /**
     * Struct member jourEntree
     */
    public modControledAcces.Date jourEntree;

    /**
     * Struct member jourSortie
     */
    public modControledAcces.Date jourSortie;

    /**
     * Struct member heureEntree
     */
    public modControledAcces.Date heureEntree;

    /**
     * Struct member heureSortie
     */
    public modControledAcces.Date heureSortie;

    /**
     * Default constructor
     */
    public AccesZone()
    { }

    /**
     * Constructor with fields initialization
     * @param idSal idSal struct member
     * @param idZone idZone struct member
     * @param dateDdeAcces dateDdeAcces struct member
     * @param statutAcces statutAcces struct member
     * @param jourEntree jourEntree struct member
     * @param jourSortie jourSortie struct member
     * @param heureEntree heureEntree struct member
     * @param heureSortie heureSortie struct member
     */
    public AccesZone(String idSal, String idZone, modControledAcces.Date dateDdeAcces, boolean statutAcces, modControledAcces.Date jourEntree, modControledAcces.Date jourSortie, modControledAcces.Date heureEntree, modControledAcces.Date heureSortie)
    {
        this.idSal = idSal;
        this.idZone = idZone;
        this.dateDdeAcces = dateDdeAcces;
        this.statutAcces = statutAcces;
        this.jourEntree = jourEntree;
        this.jourSortie = jourSortie;
        this.heureEntree = heureEntree;
        this.heureSortie = heureSortie;
    }

}
