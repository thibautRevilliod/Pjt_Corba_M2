package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAnnuaire
 * 
 * @author OpenORB Compiler
 */
public abstract class EntiteLogicielleAnnuairePOA extends org.omg.PortableServer.Servant
        implements EntiteLogicielleAnnuaireOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EntiteLogicielleAnnuaire _this()
    {
        return EntiteLogicielleAnnuaireHelper.narrow(_this_object());
    }

    public EntiteLogicielleAnnuaire _this(org.omg.CORBA.ORB orb)
    {
        return EntiteLogicielleAnnuaireHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleAnnuaire:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("creerSalarie")) {
                return _invoke_creerSalarie(_is, handler);
        } else if (opName.equals("infosSalarie")) {
                return _invoke_infosSalarie(_is, handler);
        } else if (opName.equals("listeSalariesTemporaires")) {
                return _invoke_listeSalariesTemporaires(_is, handler);
        } else if (opName.equals("listeTousSalaries")) {
                return _invoke_listeTousSalaries(_is, handler);
        } else if (opName.equals("recupererNomPhotoSalarie")) {
                return _invoke_recupererNomPhotoSalarie(_is, handler);
        } else if (opName.equals("sauthentifier")) {
                return _invoke_sauthentifier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_listeTousSalaries(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modControledAcces.InfoSalarie[] _arg_result = listeTousSalaries();

        _output = handler.createReply();
        modControledAcces.ListeSalariesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_listeSalariesTemporaires(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modControledAcces.InfoSalarie[] _arg_result = listeSalariesTemporaires();

        _output = handler.createReply();
        modControledAcces.ListeSalariesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererNomPhotoSalarie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            modControledAcces.InfoSalarie _arg_result = recupererNomPhotoSalarie(arg0_in, arg1_in);

            _output = handler.createReply();
            modControledAcces.InfoSalarieHelper.write(_output,_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        catch (modControledAcces.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_infosSalarie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            modControledAcces.InfoSalarie _arg_result = infosSalarie(arg0_in, arg1_in);

            _output = handler.createReply();
            modControledAcces.InfoSalarieHelper.write(_output,_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        catch (modControledAcces.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.CleInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerSalarie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();
        String arg3_in = _is.read_string();
        modControledAcces.Date arg4_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg5_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg6_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg7_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg8_in = modControledAcces.DateHelper.read(_is);
        boolean arg9_in = _is.read_boolean();

        try
        {
            String _arg_result = creerSalarie(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in, arg6_in, arg7_in, arg8_in, arg9_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

        }
        catch (modControledAcces.ErreurSalarieExistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieExistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_sauthentifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            String _arg_result = sauthentifier(arg0_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

}
