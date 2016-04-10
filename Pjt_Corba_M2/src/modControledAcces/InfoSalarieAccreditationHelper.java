package modControledAcces;

/** 
 * Helper class for : InfoSalarieAccreditation
 *  
 * @author OpenORB Compiler
 */ 
public class InfoSalarieAccreditationHelper
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
     * Insert InfoSalarieAccreditation into an any
     * @param a an any
     * @param t InfoSalarieAccreditation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.InfoSalarieAccreditation t)
    {
        a.insert_Streamable(new modControledAcces.InfoSalarieAccreditationHolder(t));
    }

    /**
     * Extract InfoSalarieAccreditation from an any
     * @param a an any
     * @return the extracted InfoSalarieAccreditation value
     */
    public static modControledAcces.InfoSalarieAccreditation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.InfoSalarieAccreditationHolder)
                    return ((modControledAcces.InfoSalarieAccreditationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.InfoSalarieAccreditationHolder h = new modControledAcces.InfoSalarieAccreditationHolder(read(a.create_input_stream()));
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
     * Return the InfoSalarieAccreditation TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idSal";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "listeAccreditationSal";
                _members[1].type = modControledAcces.ListeAccreditationZoneHelper.type();
                _tc = orb.create_struct_tc(id(),"InfoSalarieAccreditation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the InfoSalarieAccreditation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/InfoSalarieAccreditation:1.0";

    /**
     * Read InfoSalarieAccreditation from a marshalled stream
     * @param istream the input stream
     * @return the readed InfoSalarieAccreditation value
     */
    public static modControledAcces.InfoSalarieAccreditation read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.InfoSalarieAccreditation new_one = new modControledAcces.InfoSalarieAccreditation();

        new_one.idSal = istream.read_string();
        new_one.listeAccreditationSal = modControledAcces.ListeAccreditationZoneHelper.read(istream);

        return new_one;
    }

    /**
     * Write InfoSalarieAccreditation into a marshalled stream
     * @param ostream the output stream
     * @param value InfoSalarieAccreditation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.InfoSalarieAccreditation value)
    {
        ostream.write_string(value.idSal);
        modControledAcces.ListeAccreditationZoneHelper.write(ostream,value.listeAccreditationSal);
    }

}
