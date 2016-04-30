package modControledAcces;

/**
 * Holder class for : ListeSalaries
 * 
 * @author OpenORB Compiler
 */
final public class ListeSalariesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeSalaries value
     */
    public modControledAcces.InfoSalarie[] value;

    /**
     * Default constructor
     */
    public ListeSalariesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeSalariesHolder(modControledAcces.InfoSalarie[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeSalaries from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeSalariesHelper.read(istream);
    }

    /**
     * Write ListeSalaries into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeSalariesHelper.write(ostream,value);
    }

    /**
     * Return the ListeSalaries TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeSalariesHelper.type();
    }

}
