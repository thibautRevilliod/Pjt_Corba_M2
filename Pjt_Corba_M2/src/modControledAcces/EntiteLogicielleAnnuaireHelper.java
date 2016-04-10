package modControledAcces;

/** 
 * Helper class for : EntiteLogicielleAnnuaire
 *  
 * @author OpenORB Compiler
 */ 
public class EntiteLogicielleAnnuaireHelper
{
    /**
     * Insert EntiteLogicielleAnnuaire into an any
     * @param a an any
     * @param t EntiteLogicielleAnnuaire value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EntiteLogicielleAnnuaire t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EntiteLogicielleAnnuaire from an any
     * @param a an any
     * @return the extracted EntiteLogicielleAnnuaire value
     */
    public static modControledAcces.EntiteLogicielleAnnuaire extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modControledAcces.EntiteLogicielleAnnuaireHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EntiteLogicielleAnnuaire TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EntiteLogicielleAnnuaire");
        }
        return _tc;
    }

    /**
     * Return the EntiteLogicielleAnnuaire IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EntiteLogicielleAnnuaire:1.0";

    /**
     * Read EntiteLogicielleAnnuaire from a marshalled stream
     * @param istream the input stream
     * @return the readed EntiteLogicielleAnnuaire value
     */
    public static modControledAcces.EntiteLogicielleAnnuaire read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modControledAcces.EntiteLogicielleAnnuaire)istream.read_Object(modControledAcces._EntiteLogicielleAnnuaireStub.class);
    }

    /**
     * Write EntiteLogicielleAnnuaire into a marshalled stream
     * @param ostream the output stream
     * @param value EntiteLogicielleAnnuaire value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EntiteLogicielleAnnuaire value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EntiteLogicielleAnnuaire
     * @param obj the CORBA Object
     * @return EntiteLogicielleAnnuaire Object
     */
    public static EntiteLogicielleAnnuaire narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleAnnuaire)
            return (EntiteLogicielleAnnuaire)obj;

        if (obj._is_a(id()))
        {
            _EntiteLogicielleAnnuaireStub stub = new _EntiteLogicielleAnnuaireStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EntiteLogicielleAnnuaire
     * @param obj the CORBA Object
     * @return EntiteLogicielleAnnuaire Object
     */
    public static EntiteLogicielleAnnuaire unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleAnnuaire)
            return (EntiteLogicielleAnnuaire)obj;

        _EntiteLogicielleAnnuaireStub stub = new _EntiteLogicielleAnnuaireStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
