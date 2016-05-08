package modControledAcces;

/** 
 * Helper class for : ListeOperations
 *  
 * @author OpenORB Compiler
 */ 
public class ListeOperationsHelper
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
     * Insert ListeOperations into an any
     * @param a an any
     * @param t ListeOperations value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.InfoOperation[] t)
    {
        a.insert_Streamable(new modControledAcces.ListeOperationsHolder(t));
    }

    /**
     * Extract ListeOperations from an any
     * @param a an any
     * @return the extracted ListeOperations value
     */
    public static modControledAcces.InfoOperation[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.ListeOperationsHolder)
                    return ((modControledAcces.ListeOperationsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.ListeOperationsHolder h = new modControledAcces.ListeOperationsHolder(read(a.create_input_stream()));
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
     * Return the ListeOperations TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeOperations",orb.create_sequence_tc(0,modControledAcces.InfoOperationHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeOperations IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/ListeOperations:1.0";

    /**
     * Read ListeOperations from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeOperations value
     */
    public static modControledAcces.InfoOperation[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.InfoOperation[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modControledAcces.InfoOperation[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modControledAcces.InfoOperationHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeOperations into a marshalled stream
     * @param ostream the output stream
     * @param value ListeOperations value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.InfoOperation[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modControledAcces.InfoOperationHelper.write(ostream,value[i7]);

        }
    }

}
