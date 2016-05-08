package modControledAcces;

/**
 * Holder class for : InfoOperation
 * 
 * @author OpenORB Compiler
 */
final public class InfoOperationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoOperation value
     */
    public modControledAcces.InfoOperation value;

    /**
     * Default constructor
     */
    public InfoOperationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoOperationHolder(modControledAcces.InfoOperation initial)
    {
        value = initial;
    }

    /**
     * Read InfoOperation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoOperationHelper.read(istream);
    }

    /**
     * Write InfoOperation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoOperationHelper.write(ostream,value);
    }

    /**
     * Return the InfoOperation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoOperationHelper.type();
    }

}
