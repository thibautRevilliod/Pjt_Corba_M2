package modControledAcces;

/** 
 * Helper class for : ErreurPorteExistant
 *  
 * @author OpenORB Compiler
 */ 
public class ErreurPorteExistantHelper
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
     * Insert ErreurPorteExistant into an any
     * @param a an any
     * @param t ErreurPorteExistant value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.ErreurPorteExistant t)
    {
        a.insert_Streamable(new modControledAcces.ErreurPorteExistantHolder(t));
    }

    /**
     * Extract ErreurPorteExistant from an any
     * @param a an any
     * @return the extracted ErreurPorteExistant value
     */
    public static modControledAcces.ErreurPorteExistant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.ErreurPorteExistantHolder)
                    return ((modControledAcces.ErreurPorteExistantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.ErreurPorteExistantHolder h = new modControledAcces.ErreurPorteExistantHolder(read(a.create_input_stream()));
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
     * Return the ErreurPorteExistant TypeCode
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
                _members[0].name = "raisonErreurPorteExistant";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"ErreurPorteExistant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ErreurPorteExistant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/ErreurPorteExistant:1.0";

    /**
     * Read ErreurPorteExistant from a marshalled stream
     * @param istream the input stream
     * @return the readed ErreurPorteExistant value
     */
    public static modControledAcces.ErreurPorteExistant read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.ErreurPorteExistant new_one = new modControledAcces.ErreurPorteExistant();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raisonErreurPorteExistant = istream.read_string();

        return new_one;
    }

    /**
     * Write ErreurPorteExistant into a marshalled stream
     * @param ostream the output stream
     * @param value ErreurPorteExistant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.ErreurPorteExistant value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raisonErreurPorteExistant);
    }

}
