package modControledAcces;

/**
 * Holder class for : ErreurSalarieExistant
 * 
 * @author OpenORB Compiler
 */
final public class ErreurSalarieExistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurSalarieExistant value
     */
    public modControledAcces.ErreurSalarieExistant value;

    /**
     * Default constructor
     */
    public ErreurSalarieExistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurSalarieExistantHolder(modControledAcces.ErreurSalarieExistant initial)
    {
        value = initial;
    }

    /**
     * Read ErreurSalarieExistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurSalarieExistantHelper.read(istream);
    }

    /**
     * Write ErreurSalarieExistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurSalarieExistantHelper.write(ostream,value);
    }

    /**
     * Return the ErreurSalarieExistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurSalarieExistantHelper.type();
    }

}
