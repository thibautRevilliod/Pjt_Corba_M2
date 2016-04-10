package modControledAcces;

/**
 * Holder class for : AccreditationZone
 * 
 * @author OpenORB Compiler
 */
final public class AccreditationZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AccreditationZone value
     */
    public modControledAcces.AccreditationZone value;

    /**
     * Default constructor
     */
    public AccreditationZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AccreditationZoneHolder(modControledAcces.AccreditationZone initial)
    {
        value = initial;
    }

    /**
     * Read AccreditationZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AccreditationZoneHelper.read(istream);
    }

    /**
     * Write AccreditationZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AccreditationZoneHelper.write(ostream,value);
    }

    /**
     * Return the AccreditationZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AccreditationZoneHelper.type();
    }

}
