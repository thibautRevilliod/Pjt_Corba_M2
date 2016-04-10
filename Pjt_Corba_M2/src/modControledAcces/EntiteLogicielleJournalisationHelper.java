package modControledAcces;

/** 
 * Helper class for : EntiteLogicielleJournalisation
 *  
 * @author OpenORB Compiler
 */ 
public class EntiteLogicielleJournalisationHelper
{
    /**
     * Insert EntiteLogicielleJournalisation into an any
     * @param a an any
     * @param t EntiteLogicielleJournalisation value
     */
    public static void insert(org.omg.CORBA.Any a, modControledAcces.EntiteLogicielleJournalisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EntiteLogicielleJournalisation from an any
     * @param a an any
     * @return the extracted EntiteLogicielleJournalisation value
     */
    public static modControledAcces.EntiteLogicielleJournalisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modControledAcces.EntiteLogicielleJournalisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EntiteLogicielleJournalisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EntiteLogicielleJournalisation");
        }
        return _tc;
    }

    /**
     * Return the EntiteLogicielleJournalisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modControledAcces/EntiteLogicielleJournalisation:1.0";

    /**
     * Read EntiteLogicielleJournalisation from a marshalled stream
     * @param istream the input stream
     * @return the readed EntiteLogicielleJournalisation value
     */
    public static modControledAcces.EntiteLogicielleJournalisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modControledAcces.EntiteLogicielleJournalisation)istream.read_Object(modControledAcces._EntiteLogicielleJournalisationStub.class);
    }

    /**
     * Write EntiteLogicielleJournalisation into a marshalled stream
     * @param ostream the output stream
     * @param value EntiteLogicielleJournalisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modControledAcces.EntiteLogicielleJournalisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EntiteLogicielleJournalisation
     * @param obj the CORBA Object
     * @return EntiteLogicielleJournalisation Object
     */
    public static EntiteLogicielleJournalisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleJournalisation)
            return (EntiteLogicielleJournalisation)obj;

        if (obj._is_a(id()))
        {
            _EntiteLogicielleJournalisationStub stub = new _EntiteLogicielleJournalisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EntiteLogicielleJournalisation
     * @param obj the CORBA Object
     * @return EntiteLogicielleJournalisation Object
     */
    public static EntiteLogicielleJournalisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EntiteLogicielleJournalisation)
            return (EntiteLogicielleJournalisation)obj;

        _EntiteLogicielleJournalisationStub stub = new _EntiteLogicielleJournalisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
