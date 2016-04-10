package modControledAcces;

/**
 * Holder class for : EvenementJournalisation
 * 
 * @author OpenORB Compiler
 */
final public class EvenementJournalisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EvenementJournalisation value
     */
    public modControledAcces.EvenementJournalisation value;

    /**
     * Default constructor
     */
    public EvenementJournalisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EvenementJournalisationHolder(modControledAcces.EvenementJournalisation initial)
    {
        value = initial;
    }

    /**
     * Read EvenementJournalisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EvenementJournalisationHelper.read(istream);
    }

    /**
     * Write EvenementJournalisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EvenementJournalisationHelper.write(ostream,value);
    }

    /**
     * Return the EvenementJournalisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EvenementJournalisationHelper.type();
    }

}
