package modControledAcces;

/**
 * Holder class for : ListeAccreditationZone
 * 
 * @author OpenORB Compiler
 */
final public class ListeAccreditationZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeAccreditationZone value
     */
    public modControledAcces.AccreditationZone[] value;

    /**
     * Default constructor
     */
    public ListeAccreditationZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeAccreditationZoneHolder(modControledAcces.AccreditationZone[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeAccreditationZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeAccreditationZoneHelper.read(istream);
    }

    /**
     * Write ListeAccreditationZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeAccreditationZoneHelper.write(ostream,value);
    }

    /**
     * Return the ListeAccreditationZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeAccreditationZoneHelper.type();
    }

}
