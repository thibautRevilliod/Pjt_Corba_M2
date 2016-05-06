package modControledAcces;

/** 
 * Helper class for : AccesZone
 *  
 * @author OpenORB Compiler
 */ 
public class AccesZoneHelper
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
     * Insert AccesZone into an any
     * @param a an any
     * @param t AccesZone value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.AccesZone t)
    {
        a.insert_Streamable(new modControledAcces.AccesZoneHolder(t));
    }

    /**
     * Extract AccesZone from an any
     * @param a an any
     * @return the extracted AccesZone value
     */
    public static modControledAcces.AccesZone extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.AccesZoneHolder)
                    return ((modControledAcces.AccesZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.AccesZoneHolder h = new modControledAcces.AccesZoneHolder(read(a.create_input_stream()));
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
     * Return the AccesZone TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idSal";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "idZone";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "statutAcces";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "jourHeure";
                _members[3].type = modControledAcces.DateHelper.type();
                _tc = orb.create_struct_tc(id(),"AccesZone",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AccesZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/AccesZone:1.0";

    /**
     * Read AccesZone from a marshalled stream
     * @param istream the input stream
     * @return the readed AccesZone value
     */
    public static modControledAcces.AccesZone read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.AccesZone new_one = new modControledAcces.AccesZone();

        new_one.idSal = istream.read_string();
        new_one.idZone = istream.read_string();
        new_one.statutAcces = istream.read_boolean();
        new_one.jourHeure = modControledAcces.DateHelper.read(istream);

        return new_one;
    }

    /**
     * Write AccesZone into a marshalled stream
     * @param ostream the output stream
     * @param value AccesZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.AccesZone value)
    {
        ostream.write_string(value.idSal);
        ostream.write_string(value.idZone);
        ostream.write_boolean(value.statutAcces);
        modControledAcces.DateHelper.write(ostream,value.jourHeure);
    }

}
