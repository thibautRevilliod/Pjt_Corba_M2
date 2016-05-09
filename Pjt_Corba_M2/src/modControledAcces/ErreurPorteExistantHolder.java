package modControledAcces;

/**
 * Holder class for : ErreurPorteExistant
 * 
 * @author OpenORB Compiler
 */
final public class ErreurPorteExistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurPorteExistant value
     */
    public modControledAcces.ErreurPorteExistant value;

    /**
     * Default constructor
     */
    public ErreurPorteExistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurPorteExistantHolder(modControledAcces.ErreurPorteExistant initial)
    {
        value = initial;
    }

    /**
     * Read ErreurPorteExistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurPorteExistantHelper.read(istream);
    }

    /**
     * Write ErreurPorteExistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurPorteExistantHelper.write(ostream,value);
    }

    /**
     * Return the ErreurPorteExistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurPorteExistantHelper.type();
    }

}
