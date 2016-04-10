package modControledAcces;

/** 
 * Helper class for : EntiteLogicielleAutorisation
 *  
 * @author OpenORB Compiler
 */ 
public class EntiteLogicielleAutorisationHelper
{
    /**
     * Insert EntiteLogicielleAutorisation into an any
     * @param a an any
     * @param t EntiteLogicielleAutorisation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EntiteLogicielleAutorisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EntiteLogicielleAutorisation from an any
     * @param a an any
     * @return the extracted EntiteLogicielleAutorisation value
     */
    public static modControledAcces.EntiteLogicielleAutorisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modControledAcces.EntiteLogicielleAutorisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EntiteLogicielleAutorisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EntiteLogicielleAutorisation");
        }
        return _tc;
    }

    /**
     * Return the EntiteLogicielleAutorisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EntiteLogicielleAutorisation:1.0";

    /**
     * Read EntiteLogicielleAutorisation from a marshalled stream
     * @param istream the input stream
     * @return the readed EntiteLogicielleAutorisation value
     */
    public static modControledAcces.EntiteLogicielleAutorisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modControledAcces.EntiteLogicielleAutorisation)istream.read_Object(modControledAcces._EntiteLogicielleAutorisationStub.class);
    }

    /**
     * Write EntiteLogicielleAutorisation into a marshalled stream
     * @param ostream the output stream
     * @param value EntiteLogicielleAutorisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EntiteLogicielleAutorisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EntiteLogicielleAutorisation
     * @param obj the CORBA Object
     * @return EntiteLogicielleAutorisation Object
     */
    public static EntiteLogicielleAutorisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleAutorisation)
            return (EntiteLogicielleAutorisation)obj;

        if (obj._is_a(id()))
        {
            _EntiteLogicielleAutorisationStub stub = new _EntiteLogicielleAutorisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EntiteLogicielleAutorisation
     * @param obj the CORBA Object
     * @return EntiteLogicielleAutorisation Object
     */
    public static EntiteLogicielleAutorisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleAutorisation)
            return (EntiteLogicielleAutorisation)obj;

        _EntiteLogicielleAutorisationStub stub = new _EntiteLogicielleAutorisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
