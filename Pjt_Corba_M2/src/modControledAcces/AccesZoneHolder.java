package modControledAcces;

/**
 * Holder class for : AccesZone
 * 
 * @author OpenORB Compiler
 */
final public class AccesZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AccesZone value
     */
    public modControledAcces.AccesZone value;

    /**
     * Default constructor
     */
    public AccesZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AccesZoneHolder(modControledAcces.AccesZone initial)
    {
        value = initial;
    }

    /**
     * Read AccesZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AccesZoneHelper.read(istream);
    }

    /**
     * Write AccesZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AccesZoneHelper.write(ostream,value);
    }

    /**
     * Return the AccesZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AccesZoneHelper.type();
    }

}
