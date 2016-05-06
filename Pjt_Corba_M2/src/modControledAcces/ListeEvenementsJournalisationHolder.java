package modControledAcces;

/**
 * Holder class for : ListeEvenementsJournalisation
 * 
 * @author OpenORB Compiler
 */
final public class ListeEvenementsJournalisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeEvenementsJournalisation value
     */
    public modControledAcces.EvenementJournalisation[] value;

    /**
     * Default constructor
     */
    public ListeEvenementsJournalisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeEvenementsJournalisationHolder(modControledAcces.EvenementJournalisation[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeEvenementsJournalisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeEvenementsJournalisationHelper.read(istream);
    }

    /**
     * Write ListeEvenementsJournalisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeEvenementsJournalisationHelper.write(ostream,value);
    }

    /**
     * Return the ListeEvenementsJournalisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeEvenementsJournalisationHelper.type();
    }

}
