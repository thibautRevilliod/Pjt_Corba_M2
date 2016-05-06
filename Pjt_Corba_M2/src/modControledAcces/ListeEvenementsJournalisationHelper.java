package modControledAcces;

/** 
 * Helper class for : ListeEvenementsJournalisation
 *  
 * @author OpenORB Compiler
 */ 
public class ListeEvenementsJournalisationHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert ListeEvenementsJournalisation into an any
     * @param a an any
     * @param t ListeEvenementsJournalisation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EvenementJournalisation[] t)
    {
        a.insert_Streamable(new modControledAcces.ListeEvenementsJournalisationHolder(t));
    }

    /**
     * Extract ListeEvenementsJournalisation from an any
     * @param a an any
     * @return the extracted ListeEvenementsJournalisation value
     */
    public static modControledAcces.EvenementJournalisation[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.ListeEvenementsJournalisationHolder)
                    return ((modControledAcces.ListeEvenementsJournalisationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.ListeEvenementsJournalisationHolder h = new modControledAcces.ListeEvenementsJournalisationHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ListeEvenementsJournalisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeEvenementsJournalisation",orb.create_sequence_tc(0,modControledAcces.EvenementJournalisationHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeEvenementsJournalisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/ListeEvenementsJournalisation:1.0";

    /**
     * Read ListeEvenementsJournalisation from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeEvenementsJournalisation value
     */
    public static modControledAcces.EvenementJournalisation[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.EvenementJournalisation[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modControledAcces.EvenementJournalisation[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modControledAcces.EvenementJournalisationHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeEvenementsJournalisation into a marshalled stream
     * @param ostream the output stream
     * @param value ListeEvenementsJournalisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EvenementJournalisation[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modControledAcces.EvenementJournalisationHelper.write(ostream,value[i7]);

        }
    }

}
