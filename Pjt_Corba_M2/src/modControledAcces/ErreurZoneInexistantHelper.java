package modControledAcces;

/** 
 * Helper class for : ErreurZoneInexistant
 *  
 * @author OpenORB Compiler
 */ 
public class ErreurZoneInexistantHelper
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
     * Insert ErreurZoneInexistant into an any
     * @param a an any
     * @param t ErreurZoneInexistant value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.ErreurZoneInexistant t)
    {
        a.insert_Streamable(new modControledAcces.ErreurZoneInexistantHolder(t));
    }

    /**
     * Extract ErreurZoneInexistant from an any
     * @param a an any
     * @return the extracted ErreurZoneInexistant value
     */
    public static modControledAcces.ErreurZoneInexistant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.ErreurZoneInexistantHolder)
                    return ((modControledAcces.ErreurZoneInexistantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.ErreurZoneInexistantHolder h = new modControledAcces.ErreurZoneInexistantHolder(read(a.create_input_stream()));
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
     * Return the ErreurZoneInexistant TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "raisonErreurZoneInexistant";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"ErreurZoneInexistant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ErreurZoneInexistant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/ErreurZoneInexistant:1.0";

    /**
     * Read ErreurZoneInexistant from a marshalled stream
     * @param istream the input stream
     * @return the readed ErreurZoneInexistant value
     */
    public static modControledAcces.ErreurZoneInexistant read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.ErreurZoneInexistant new_one = new modControledAcces.ErreurZoneInexistant();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raisonErreurZoneInexistant = istream.read_string();

        return new_one;
    }

    /**
     * Write ErreurZoneInexistant into a marshalled stream
     * @param ostream the output stream
     * @param value ErreurZoneInexistant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.ErreurZoneInexistant value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raisonErreurZoneInexistant);
    }

}
