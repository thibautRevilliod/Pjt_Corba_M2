package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAutorisation
 * 
 * @author OpenORB Compiler
 */
public abstract class EntiteLogicielleAutorisationPOA extends org.omg.PortableServer.Servant
        implements EntiteLogicielleAutorisationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EntiteLogicielleAutorisation _this()
    {
        return EntiteLogicielleAutorisationHelper.narrow(_this_object());
    }

    public EntiteLogicielleAutorisation _this(org.omg.CORBA.ORB orb)
    {
        return EntiteLogicielleAutorisationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleAutorisation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("creerAccreditation")) {
                return _invoke_creerAccreditation(_is, handler);
        } else if (opName.equals("lireAccreditationSalarie")) {
                return _invoke_lireAccreditationSalarie(_is, handler);
        } else if (opName.equals("listeToutesZones")) {
                return _invoke_listeToutesZones(_is, handler);
        } else if (opName.equals("modifierAccreditation")) {
                return _invoke_modifierAccreditation(_is, handler);
        } else if (opName.equals("supprimerAccreditation")) {
                return _invoke_supprimerAccreditation(_is, handler);
        } else if (opName.equals("verifierAutorisation")) {
                return _invoke_verifierAutorisation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_listeToutesZones(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modControledAcces.InfoZone[] _arg_result = listeToutesZones();

        _output = handler.createReply();
        modControledAcces.ListeZonesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAutorisation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            boolean _arg_result = verifierAutorisation(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        catch (modControledAcces.ErreurZoneInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurZoneInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerAccreditation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        modControledAcces.Date arg2_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg3_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg4_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg5_in = modControledAcces.DateHelper.read(_is);
        String arg6_in = _is.read_string();

        try
        {
            creerAccreditation(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in, arg6_in);

            _output = handler.createReply();

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
        catch (modControledAcces.ErreurZoneInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurZoneInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_lireAccreditationSalarie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            modControledAcces.InfoSalarieAccreditation _arg_result = lireAccreditationSalarie(arg0_in);

            _output = handler.createReply();
            modControledAcces.InfoSalarieAccreditationHelper.write(_output,_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierAccreditation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        modControledAcces.Date arg2_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg3_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg4_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.Date arg5_in = modControledAcces.DateHelper.read(_is);
        modControledAcces.EntiteLogicielleEmpreinte arg6_in = modControledAcces.EntiteLogicielleEmpreinteHelper.read(_is);

        try
        {
            modControledAcces.InfoSalarieAccreditation _arg_result = modifierAccreditation(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in, arg6_in);

            _output = handler.createReply();
            modControledAcces.InfoSalarieAccreditationHelper.write(_output,_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        catch (modControledAcces.ErreurZoneInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurZoneInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAccreditation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        modControledAcces.EntiteLogicielleEmpreinte arg2_in = modControledAcces.EntiteLogicielleEmpreinteHelper.read(_is);

        try
        {
            modControledAcces.InfoSalarieAccreditation _arg_result = supprimerAccreditation(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            modControledAcces.InfoSalarieAccreditationHelper.write(_output,_arg_result);

        }
        catch (modControledAcces.ErreurSalarieInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurSalarieInexistantHelper.write(_output,_exception);
        }
        catch (modControledAcces.ErreurZoneInexistant _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.ErreurZoneInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

}
