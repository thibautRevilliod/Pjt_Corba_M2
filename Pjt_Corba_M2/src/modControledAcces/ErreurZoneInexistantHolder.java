package modControledAcces;

/**
 * Holder class for : ErreurZoneInexistant
 * 
 * @author OpenORB Compiler
 */
final public class ErreurZoneInexistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurZoneInexistant value
     */
    public modControledAcces.ErreurZoneInexistant value;

    /**
     * Default constructor
     */
    public ErreurZoneInexistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurZoneInexistantHolder(modControledAcces.ErreurZoneInexistant initial)
    {
        value = initial;
    }

    /**
     * Read ErreurZoneInexistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurZoneInexistantHelper.read(istream);
    }

    /**
     * Write ErreurZoneInexistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurZoneInexistantHelper.write(ostream,value);
    }

    /**
     * Return the ErreurZoneInexistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurZoneInexistantHelper.type();
    }

}
