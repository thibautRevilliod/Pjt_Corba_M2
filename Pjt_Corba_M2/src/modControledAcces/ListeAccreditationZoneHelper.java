package modControledAcces;

/** 
 * Helper class for : ListeAccreditationZone
 *  
 * @author OpenORB Compiler
 */ 
public class ListeAccreditationZoneHelper
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
     * Insert ListeAccreditationZone into an any
     * @param a an any
     * @param t ListeAccreditationZone value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.AccreditationZone[] t)
    {
        a.insert_Streamable(new modControledAcces.ListeAccreditationZoneHolder(t));
    }

    /**
     * Extract ListeAccreditationZone from an any
     * @param a an any
     * @return the extracted ListeAccreditationZone value
     */
    public static modControledAcces.AccreditationZone[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.ListeAccreditationZoneHolder)
                    return ((modControledAcces.ListeAccreditationZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.ListeAccreditationZoneHolder h = new modControledAcces.ListeAccreditationZoneHolder(read(a.create_input_stream()));
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
     * Return the ListeAccreditationZone TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeAccreditationZone",orb.create_sequence_tc(0,modControledAcces.AccreditationZoneHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeAccreditationZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/ListeAccreditationZone:1.0";

    /**
     * Read ListeAccreditationZone from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeAccreditationZone value
     */
    public static modControledAcces.AccreditationZone[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.AccreditationZone[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modControledAcces.AccreditationZone[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modControledAcces.AccreditationZoneHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeAccreditationZone into a marshalled stream
     * @param ostream the output stream
     * @param value ListeAccreditationZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.AccreditationZone[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modControledAcces.AccreditationZoneHelper.write(ostream,value[i7]);

        }
    }

}
