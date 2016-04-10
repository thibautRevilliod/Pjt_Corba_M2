package modControledAcces;

/**
 * Holder class for : EntiteLogicielleEmpreinte
 * 
 * @author OpenORB Compiler
 */
final public class EntiteLogicielleEmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntiteLogicielleEmpreinte value
     */
    public modControledAcces.EntiteLogicielleEmpreinte value;

    /**
     * Default constructor
     */
    public EntiteLogicielleEmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntiteLogicielleEmpreinteHolder(modControledAcces.EntiteLogicielleEmpreinte initial)
    {
        value = initial;
    }

    /**
     * Read EntiteLogicielleEmpreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntiteLogicielleEmpreinteHelper.read(istream);
    }

    /**
     * Write EntiteLogicielleEmpreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntiteLogicielleEmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the EntiteLogicielleEmpreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntiteLogicielleEmpreinteHelper.type();
    }

}
