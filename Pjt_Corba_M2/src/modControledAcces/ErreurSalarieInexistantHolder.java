package modControledAcces;

/**
 * Holder class for : ErreurSalarieInexistant
 * 
 * @author OpenORB Compiler
 */
final public class ErreurSalarieInexistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurSalarieInexistant value
     */
    public modControledAcces.ErreurSalarieInexistant value;

    /**
     * Default constructor
     */
    public ErreurSalarieInexistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurSalarieInexistantHolder(modControledAcces.ErreurSalarieInexistant initial)
    {
        value = initial;
    }

    /**
     * Read ErreurSalarieInexistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurSalarieInexistantHelper.read(istream);
    }

    /**
     * Write ErreurSalarieInexistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurSalarieInexistantHelper.write(ostream,value);
    }

    /**
     * Return the ErreurSalarieInexistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurSalarieInexistantHelper.type();
    }

}
