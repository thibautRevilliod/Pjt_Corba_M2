package modControledAcces;

/** 
 * Helper class for : InfoOperation
 *  
 * @author OpenORB Compiler
 */ 
public class InfoOperationHelper
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
     * Insert InfoOperation into an any
     * @param a an any
     * @param t InfoOperation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.InfoOperation t)
    {
        a.insert_Streamable(new modControledAcces.InfoOperationHolder(t));
    }

    /**
     * Extract InfoOperation from an any
     * @param a an any
     * @return the extracted InfoOperation value
     */
    public static modControledAcces.InfoOperation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modControledAcces.InfoOperationHolder)
                    return ((modControledAcces.InfoOperationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modControledAcces.InfoOperationHolder h = new modControledAcces.InfoOperationHolder(read(a.create_input_stream()));
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
     * Return the InfoOperation TypeCode
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
                _members[0].name = "operation";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"InfoOperation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the InfoOperation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/InfoOperation:1.0";

    /**
     * Read InfoOperation from a marshalled stream
     * @param istream the input stream
     * @return the readed InfoOperation value
     */
    public static modControledAcces.InfoOperation read(org.omg.CORBA.portable.InputStream istream)
    {
        modControledAcces.InfoOperation new_one = new modControledAcces.InfoOperation();

        new_one.operation = istream.read_string();

        return new_one;
    }

    /**
     * Write InfoOperation into a marshalled stream
     * @param ostream the output stream
     * @param value InfoOperation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.InfoOperation value)
    {
        ostream.write_string(value.operation);
    }

}
