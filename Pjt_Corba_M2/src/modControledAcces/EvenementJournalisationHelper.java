package modControledAcces;

/** 
 * Helper class for : EvenementJournalisation
 *  
 * @author OpenORB Compiler
 */ 
public class EvenementJournalisationHelper
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
     * Insert EvenementJournalisation into an any
     * @param a an any
     * @param t EvenementJournalisation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EvenementJournalisation t)
    {
        a.insert_Streamable(new modControledAcces.EvenementJournalisationHolder(t));
    }

    /**
     * Extract EvenementJournalisation from an any
     * @param a an any
     * @return the extracted EvenementJournalisation value
     */
    public static modControledAcces.EvenementJournalisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.EvenementJournalisationHolder)
                    return ((modControledAcces.EvenementJournalisationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.EvenementJournalisationHolder h = new modControledAcces.EvenementJournalisationHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the EvenementJournalisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "accesZoneSal";
                _members[0].type = modControledAcces.AccesZoneHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "operation";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "contenuOperation";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"EvenementJournalisation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the EvenementJournalisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EvenementJournalisation:1.0";

    /**
     * Read EvenementJournalisation from a marshalled stream
     * @param istream the input stream
     * @return the readed EvenementJournalisation value
     */
    public static modControledAcces.EvenementJournalisation read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.EvenementJournalisation new_one = new modControledAcces.EvenementJournalisation();

        new_one.accesZoneSal = modControledAcces.AccesZoneHelper.read(istream);
        new_one.operation = istream.read_string();
        new_one.contenuOperation = istream.read_string();

        return new_one;
    }

    /**
     * Write EvenementJournalisation into a marshalled stream
     * @param ostream the output stream
     * @param value EvenementJournalisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EvenementJournalisation value)
    {
        modControledAcces.AccesZoneHelper.write(ostream,value.accesZoneSal);
        ostream.write_string(value.operation);
        ostream.write_string(value.contenuOperation);
    }

}
