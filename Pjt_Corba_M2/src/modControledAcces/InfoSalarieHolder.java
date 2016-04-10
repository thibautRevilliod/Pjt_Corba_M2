package modControledAcces;

/**
 * Holder class for : InfoSalarie
 * 
 * @author OpenORB Compiler
 */
final public class InfoSalarieHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoSalarie value
     */
    public modControledAcces.InfoSalarie value;

    /**
     * Default constructor
     */
    public InfoSalarieHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoSalarieHolder(modControledAcces.InfoSalarie initial)
    {
        value = initial;
    }

    /**
     * Read InfoSalarie from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoSalarieHelper.read(istream);
    }

    /**
     * Write InfoSalarie into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoSalarieHelper.write(ostream,value);
    }

    /**
     * Return the InfoSalarie TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoSalarieHelper.type();
    }

}
