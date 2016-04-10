package modControledAcces;

/**
 * Holder class for : ListeZones
 * 
 * @author OpenORB Compiler
 */
final public class ListeZonesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeZones value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public ListeZonesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeZonesHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeZones from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeZonesHelper.read(istream);
    }

    /**
     * Write ListeZones into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeZonesHelper.write(ostream,value);
    }

    /**
     * Return the ListeZones TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeZonesHelper.type();
    }

}
