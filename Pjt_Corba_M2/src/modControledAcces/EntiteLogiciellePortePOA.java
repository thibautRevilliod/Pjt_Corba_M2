package modControledAcces;

/**
 * Interface definition : EntiteLogiciellePorte
 * 
 * @author OpenORB Compiler
 */
public abstract class EntiteLogiciellePortePOA extends org.omg.PortableServer.Servant
        implements EntiteLogiciellePorteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EntiteLogiciellePorte _this()
    {
        return EntiteLogiciellePorteHelper.narrow(_this_object());
    }

    public EntiteLogiciellePorte _this(org.omg.CORBA.ORB orb)
    {
        return EntiteLogiciellePorteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogiciellePorte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("afficherMessage")) {
                return _invoke_afficherMessage(_is, handler);
        } else if (opName.equals("demandeEntrerSortirZone")) {
                return _invoke_demandeEntrerSortirZone(_is, handler);
        } else if (opName.equals("demanderAuthentifier")) {
                return _invoke_demanderAuthentifier(_is, handler);
        } else if (opName.equals("demanderModifierEmpreinte")) {
                return _invoke_demanderModifierEmpreinte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_afficherMessage(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        afficherMessage();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demandeEntrerSortirZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        demandeEntrerSortirZone(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderAuthentifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        demanderAuthentifier(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderModifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        demanderModifierEmpreinte(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
