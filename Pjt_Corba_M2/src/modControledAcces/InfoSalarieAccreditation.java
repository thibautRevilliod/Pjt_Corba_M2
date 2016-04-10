package modControledAcces;

/**
 * Struct definition : InfoSalarieAccreditation
 * 
 * @author OpenORB Compiler
*/
public final class InfoSalarieAccreditation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idSal
     */
    public String idSal;

    /**
     * Struct member listeAccreditationSal
     */
    public modControledAcces.AccreditationZone[] listeAccreditationSal;

    /**
     * Default constructor
     */
    public InfoSalarieAccreditation()
    { }

    /**
     * Constructor with fields initialization
     * @param idSal idSal struct member
     * @param listeAccreditationSal listeAccreditationSal struct member
     */
    public InfoSalarieAccreditation(String idSal, modControledAcces.AccreditationZone[] listeAccreditationSal)
    {
        this.idSal = idSal;
        this.listeAccreditationSal = listeAccreditationSal;
    }

}
