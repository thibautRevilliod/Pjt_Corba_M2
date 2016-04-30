package modControledAcces;

/**
 * Holder class for : InfoZone
 * 
 * @author OpenORB Compiler
 */
final public class InfoZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoZone value
     */
    public modControledAcces.InfoZone value;

    /**
     * Default constructor
     */
    public InfoZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoZoneHolder(modControledAcces.InfoZone initial)
    {
        value = initial;
    }

    /**
     * Read InfoZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoZoneHelper.read(istream);
    }

    /**
     * Write InfoZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoZoneHelper.write(ostream,value);
    }

    /**
     * Return the InfoZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoZoneHelper.type();
    }

}
