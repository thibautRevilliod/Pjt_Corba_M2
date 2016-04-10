package modControledAcces;

/**
 * Holder class for : EntiteLogicielleAutorisation
 * 
 * @author OpenORB Compiler
 */
final public class EntiteLogicielleAutorisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntiteLogicielleAutorisation value
     */
    public modControledAcces.EntiteLogicielleAutorisation value;

    /**
     * Default constructor
     */
    public EntiteLogicielleAutorisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntiteLogicielleAutorisationHolder(modControledAcces.EntiteLogicielleAutorisation initial)
    {
        value = initial;
    }

    /**
     * Read EntiteLogicielleAutorisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntiteLogicielleAutorisationHelper.read(istream);
    }

    /**
     * Write EntiteLogicielleAutorisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntiteLogicielleAutorisationHelper.write(ostream,value);
    }

    /**
     * Return the EntiteLogicielleAutorisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntiteLogicielleAutorisationHelper.type();
    }

}
