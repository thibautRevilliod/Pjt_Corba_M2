package modControledAcces;

/**
 * Holder class for : EntiteLogiciellePorte
 * 
 * @author OpenORB Compiler
 */
final public class EntiteLogiciellePorteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntiteLogiciellePorte value
     */
    public modControledAcces.EntiteLogiciellePorte value;

    /**
     * Default constructor
     */
    public EntiteLogiciellePorteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntiteLogiciellePorteHolder(modControledAcces.EntiteLogiciellePorte initial)
    {
        value = initial;
    }

    /**
     * Read EntiteLogiciellePorte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntiteLogiciellePorteHelper.read(istream);
    }

    /**
     * Write EntiteLogiciellePorte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntiteLogiciellePorteHelper.write(ostream,value);
    }

    /**
     * Return the EntiteLogiciellePorte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntiteLogiciellePorteHelper.type();
    }

}
