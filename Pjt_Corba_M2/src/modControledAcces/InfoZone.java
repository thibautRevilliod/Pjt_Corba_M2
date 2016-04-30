package modControledAcces;

/**
 * Struct definition : InfoZone
 * 
 * @author OpenORB Compiler
*/
public final class InfoZone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZone
     */
    public String idZone;

    /**
     * Struct member libelleZone
     */
    public String libelleZone;

    /**
     * Default constructor
     */
    public InfoZone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param libelleZone libelleZone struct member
     */
    public InfoZone(String idZone, String libelleZone)
    {
        this.idZone = idZone;
        this.libelleZone = libelleZone;
    }

}
