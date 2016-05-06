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
     * Struct member statutAcces
     */
    public boolean statutAcces;

    /**
     * Struct member jourHeure
     */
    public modControledAcces.Date jourHeure;

    /**
     * Default constructor
     */
    public AccesZone()
    { }

    /**
     * Constructor with fields initialization
     * @param idSal idSal struct member
     * @param idZone idZone struct member
     * @param statutAcces statutAcces struct member
     * @param jourHeure jourHeure struct member
     */
    public AccesZone(String idSal, String idZone, boolean statutAcces, modControledAcces.Date jourHeure)
    {
        this.idSal = idSal;
        this.idZone = idZone;
        this.statutAcces = statutAcces;
        this.jourHeure = jourHeure;
    }

}
