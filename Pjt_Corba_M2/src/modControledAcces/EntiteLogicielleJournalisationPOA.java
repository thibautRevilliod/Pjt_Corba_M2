package modControledAcces;

/**
 * Interface definition : EntiteLogicielleJournalisation
 * 
 * @author OpenORB Compiler
 */
public abstract class EntiteLogicielleJournalisationPOA extends org.omg.PortableServer.Servant
        implements EntiteLogicielleJournalisationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EntiteLogicielleJournalisation _this()
    {
        return EntiteLogicielleJournalisationHelper.narrow(_this_object());
    }

    public EntiteLogicielleJournalisation _this(org.omg.CORBA.ORB orb)
    {
        return EntiteLogicielleJournalisationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleJournalisation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("consulter")) {
                return _invoke_consulter(_is, handler);
        } else if (opName.equals("enregistrerEvenement")) {
                return _invoke_enregistrerEvenement(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_consulter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();

        modControledAcces.EvenementJournalisation _arg_result = consulter(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();
        modControledAcces.EvenementJournalisationHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerEvenement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        modControledAcces.EvenementJournalisation arg0_in = modControledAcces.EvenementJournalisationHelper.read(_is);

        enregistrerEvenement(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
