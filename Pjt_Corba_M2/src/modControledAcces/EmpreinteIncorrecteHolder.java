package modControledAcces;

/**
 * Holder class for : EmpreinteIncorrecte
 * 
 * @author OpenORB Compiler
 */
final public class EmpreinteIncorrecteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EmpreinteIncorrecte value
     */
    public modControledAcces.EmpreinteIncorrecte value;

    /**
     * Default constructor
     */
    public EmpreinteIncorrecteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreinteIncorrecteHolder(modControledAcces.EmpreinteIncorrecte initial)
    {
        value = initial;
    }

    /**
     * Read EmpreinteIncorrecte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreinteIncorrecteHelper.read(istream);
    }

    /**
     * Write EmpreinteIncorrecte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreinteIncorrecteHelper.write(ostream,value);
    }

    /**
     * Return the EmpreinteIncorrecte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreinteIncorrecteHelper.type();
    }

}
