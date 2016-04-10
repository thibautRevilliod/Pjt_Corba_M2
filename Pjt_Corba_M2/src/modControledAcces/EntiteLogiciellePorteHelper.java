package modControledAcces;

/** 
 * Helper class for : EntiteLogiciellePorte
 *  
 * @author OpenORB Compiler
 */ 
public class EntiteLogiciellePorteHelper
{
    /**
     * Insert EntiteLogiciellePorte into an any
     * @param a an any
     * @param t EntiteLogiciellePorte value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EntiteLogiciellePorte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EntiteLogiciellePorte from an any
     * @param a an any
     * @return the extracted EntiteLogiciellePorte value
     */
    public static modControledAcces.EntiteLogiciellePorte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modControledAcces.EntiteLogiciellePorteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EntiteLogiciellePorte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EntiteLogiciellePorte");
        }
        return _tc;
    }

    /**
     * Return the EntiteLogiciellePorte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EntiteLogiciellePorte:1.0";

    /**
     * Read EntiteLogiciellePorte from a marshalled stream
     * @param istream the input stream
     * @return the readed EntiteLogiciellePorte value
     */
    public static modControledAcces.EntiteLogiciellePorte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modControledAcces.EntiteLogiciellePorte)istream.read_Object(modControledAcces._EntiteLogiciellePorteStub.class);
    }

    /**
     * Write EntiteLogiciellePorte into a marshalled stream
     * @param ostream the output stream
     * @param value EntiteLogiciellePorte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EntiteLogiciellePorte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EntiteLogiciellePorte
     * @param obj the CORBA Object
     * @return EntiteLogiciellePorte Object
     */
    public static EntiteLogiciellePorte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogiciellePorte)
            return (EntiteLogiciellePorte)obj;

        if (obj._is_a(id()))
        {
            _EntiteLogiciellePorteStub stub = new _EntiteLogiciellePorteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EntiteLogiciellePorte
     * @param obj the CORBA Object
     * @return EntiteLogiciellePorte Object
     */
    public static EntiteLogiciellePorte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogiciellePorte)
            return (EntiteLogiciellePorte)obj;

        _EntiteLogiciellePorteStub stub = new _EntiteLogiciellePorteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
