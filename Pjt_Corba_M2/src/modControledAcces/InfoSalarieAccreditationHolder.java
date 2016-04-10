package modControledAcces;

/**
 * Holder class for : InfoSalarieAccreditation
 * 
 * @author OpenORB Compiler
 */
final public class InfoSalarieAccreditationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoSalarieAccreditation value
     */
    public modControledAcces.InfoSalarieAccreditation value;

    /**
     * Default constructor
     */
    public InfoSalarieAccreditationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoSalarieAccreditationHolder(modControledAcces.InfoSalarieAccreditation initial)
    {
        value = initial;
    }

    /**
     * Read InfoSalarieAccreditation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoSalarieAccreditationHelper.read(istream);
    }

    /**
     * Write InfoSalarieAccreditation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoSalarieAccreditationHelper.write(ostream,value);
    }

    /**
     * Return the InfoSalarieAccreditation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoSalarieAccreditationHelper.type();
    }

}
