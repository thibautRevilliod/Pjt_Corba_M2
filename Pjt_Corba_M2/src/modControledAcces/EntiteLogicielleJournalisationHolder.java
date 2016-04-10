package modControledAcces;

/**
 * Holder class for : EntiteLogicielleJournalisation
 * 
 * @author OpenORB Compiler
 */
final public class EntiteLogicielleJournalisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EntiteLogicielleJournalisation value
     */
    public modControledAcces.EntiteLogicielleJournalisation value;

    /**
     * Default constructor
     */
    public EntiteLogicielleJournalisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EntiteLogicielleJournalisationHolder(modControledAcces.EntiteLogicielleJournalisation initial)
    {
        value = initial;
    }

    /**
     * Read EntiteLogicielleJournalisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EntiteLogicielleJournalisationHelper.read(istream);
    }

    /**
     * Write EntiteLogicielleJournalisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EntiteLogicielleJournalisationHelper.write(ostream,value);
    }

    /**
     * Return the EntiteLogicielleJournalisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EntiteLogicielleJournalisationHelper.type();
    }

}
