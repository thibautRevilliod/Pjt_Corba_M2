package modControledAcces;

/**
 * Holder class for : EntiteLogicielleAnnuaire
 * 
 * @author OpenORB Compiler
 */
final public class EntiteLogicielleAnnuaireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntiteLogicielleAnnuaire value
     */
    public modControledAcces.EntiteLogicielleAnnuaire value;

    /**
     * Default constructor
     */
    public EntiteLogicielleAnnuaireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntiteLogicielleAnnuaireHolder(modControledAcces.EntiteLogicielleAnnuaire initial)
    {
        value = initial;
    }

    /**
     * Read EntiteLogicielleAnnuaire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntiteLogicielleAnnuaireHelper.read(istream);
    }

    /**
     * Write EntiteLogicielleAnnuaire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntiteLogicielleAnnuaireHelper.write(ostream,value);
    }

    /**
     * Return the EntiteLogicielleAnnuaire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntiteLogicielleAnnuaireHelper.type();
    }

}
