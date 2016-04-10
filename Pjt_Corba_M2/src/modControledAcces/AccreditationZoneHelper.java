package modControledAcces;

/** 
 * Helper class for : AccreditationZone
 *  
 * @author OpenORB Compiler
 */ 
public class AccreditationZoneHelper
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
     * Insert AccreditationZone into an any
     * @param a an any
     * @param t AccreditationZone value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.AccreditationZone t)
    {
        a.insert_Streamable(new modControledAcces.AccreditationZoneHolder(t));
    }

    /**
     * Extract AccreditationZone from an any
     * @param a an any
     * @return the extracted AccreditationZone value
     */
    public static modControledAcces.AccreditationZone extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.AccreditationZoneHolder)
                    return ((modControledAcces.AccreditationZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.AccreditationZoneHolder h = new modControledAcces.AccreditationZoneHolder(read(a.create_input_stream()));
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
     * Return the AccreditationZone TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[6];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idZone";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "dateAcreditation";
                _members[1].type = modControledAcces.DateHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "jourDebut";
                _members[2].type = modControledAcces.DateHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "jourFin";
                _members[3].type = modControledAcces.DateHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "heureDebut";
                _members[4].type = modControledAcces.DateHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "heureFin";
                _members[5].type = modControledAcces.DateHelper.type();
                _tc = orb.create_struct_tc(id(),"AccreditationZone",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AccreditationZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/AccreditationZone:1.0";

    /**
     * Read AccreditationZone from a marshalled stream
     * @param istream the input stream
     * @return the readed AccreditationZone value
     */
    public static modControledAcces.AccreditationZone read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.AccreditationZone new_one = new modControledAcces.AccreditationZone();

        new_one.idZone = istream.read_string();
        new_one.dateAcreditation = modControledAcces.DateHelper.read(istream);
        new_one.jourDebut = modControledAcces.DateHelper.read(istream);
        new_one.jourFin = modControledAcces.DateHelper.read(istream);
        new_one.heureDebut = modControledAcces.DateHelper.read(istream);
        new_one.heureFin = modControledAcces.DateHelper.read(istream);

        return new_one;
    }

    /**
     * Write AccreditationZone into a marshalled stream
     * @param ostream the output stream
     * @param value AccreditationZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.AccreditationZone value)
    {
        ostream.write_string(value.idZone);
        modControledAcces.DateHelper.write(ostream,value.dateAcreditation);
        modControledAcces.DateHelper.write(ostream,value.jourDebut);
        modControledAcces.DateHelper.write(ostream,value.jourFin);
        modControledAcces.DateHelper.write(ostream,value.heureDebut);
        modControledAcces.DateHelper.write(ostream,value.heureFin);
    }

}
