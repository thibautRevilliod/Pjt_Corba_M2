package modControledAcces;

/**
 * Struct definition : InfoOperation
 * 
 * @author OpenORB Compiler
*/
public final class InfoOperation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member operation
     */
    public String operation;

    /**
     * Default constructor
     */
    public InfoOperation()
    { }

    /**
     * Constructor with fields initialization
     * @param operation operation struct member
     */
    public InfoOperation(String operation)
    {
        this.operation = operation;
    }

}
