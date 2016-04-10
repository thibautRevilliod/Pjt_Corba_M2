package modControledAcces;

/** 
 * Helper class for : EntiteLogicielleEmpreinte
 *  
 * @author OpenORB Compiler
 */ 
public class EntiteLogicielleEmpreinteHelper
{
    /**
     * Insert EntiteLogicielleEmpreinte into an any
     * @param a an any
     * @param t EntiteLogicielleEmpreinte value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EntiteLogicielleEmpreinte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EntiteLogicielleEmpreinte from an any
     * @param a an any
     * @return the extracted EntiteLogicielleEmpreinte value
     */
    public static modControledAcces.EntiteLogicielleEmpreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modControledAcces.EntiteLogicielleEmpreinteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EntiteLogicielleEmpreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EntiteLogicielleEmpreinte");
        }
        return _tc;
    }

    /**
     * Return the EntiteLogicielleEmpreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EntiteLogicielleEmpreinte:1.0";

    /**
     * Read EntiteLogicielleEmpreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed EntiteLogicielleEmpreinte value
     */
    public static modControledAcces.EntiteLogicielleEmpreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modControledAcces.EntiteLogicielleEmpreinte)istream.read_Object(modControledAcces._EntiteLogicielleEmpreinteStub.class);
    }

    /**
     * Write EntiteLogicielleEmpreinte into a marshalled stream
     * @param ostream the output stream
     * @param value EntiteLogicielleEmpreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EntiteLogicielleEmpreinte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EntiteLogicielleEmpreinte
     * @param obj the CORBA Object
     * @return EntiteLogicielleEmpreinte Object
     */
    public static EntiteLogicielleEmpreinte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleEmpreinte)
            return (EntiteLogicielleEmpreinte)obj;

        if (obj._is_a(id()))
        {
            _EntiteLogicielleEmpreinteStub stub = new _EntiteLogicielleEmpreinteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EntiteLogicielleEmpreinte
     * @param obj the CORBA Object
     * @return EntiteLogicielleEmpreinte Object
     */
    public static EntiteLogicielleEmpreinte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleEmpreinte)
            return (EntiteLogicielleEmpreinte)obj;

        _EntiteLogicielleEmpreinteStub stub = new _EntiteLogicielleEmpreinteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
