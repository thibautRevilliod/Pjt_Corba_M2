package modControledAcces;

/**
 * Struct definition : Date
 * 
 * @author OpenORB Compiler
*/
public final class Date implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member timestamp
     */
    public String timestamp;

    /**
     * Default constructor
     */
    public Date()
    { }

    /**
     * Constructor with fields initialization
     * @param timestamp timestamp struct member
     */
    public Date(String timestamp)
    {
        this.timestamp = timestamp;
    }

}
