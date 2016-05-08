package modControledAcces;

/**
 * Holder class for : ListeOperations
 * 
 * @author OpenORB Compiler
 */
final public class ListeOperationsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeOperations value
     */
    public modControledAcces.InfoOperation[] value;

    /**
     * Default constructor
     */
    public ListeOperationsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeOperationsHolder(modControledAcces.InfoOperation[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeOperations from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeOperationsHelper.read(istream);
    }

    /**
     * Write ListeOperations into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeOperationsHelper.write(ostream,value);
    }

    /**
     * Return the ListeOperations TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeOperationsHelper.type();
    }

}
