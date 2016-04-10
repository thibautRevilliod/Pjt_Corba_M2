package modControledAcces;

/**
 * Interface definition : EntiteLogicielleEmpreinte
 * 
 * @author OpenORB Compiler
 */
public abstract class EntiteLogicielleEmpreintePOA extends org.omg.PortableServer.Servant
        implements EntiteLogicielleEmpreinteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EntiteLogicielleEmpreinte _this()
    {
        return EntiteLogicielleEmpreinteHelper.narrow(_this_object());
    }

    public EntiteLogicielleEmpreinte _this(org.omg.CORBA.ORB orb)
    {
        return EntiteLogicielleEmpreinteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleEmpreinte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterEmpreinte")) {
                return _invoke_ajouterEmpreinte(_is, handler);
        } else if (opName.equals("getCorrespondance")) {
                return _invoke_getCorrespondance(_is, handler);
        } else if (opName.equals("modifierEmpreinte")) {
                return _invoke_modifierEmpreinte(_is, handler);
        } else if (opName.equals("supprimerEmpreinte")) {
                return _invoke_supprimerEmpreinte(_is, handler);
        } else if (opName.equals("verifierCorrespondance")) {
                return _invoke_verifierCorrespondance(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajouterEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            ajouterEmpreinte(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (modControledAcces.EmpreinteExistante _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.EmpreinteExistanteHelper.write(_output,_exception);
        }
        catch (modControledAcces.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.CleInconnueHelper.write(_output,_exception);
        }
        catch (modControledAcces.EmpreinteIncorrecte _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.EmpreinteIncorrecteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        modControledAcces.EntiteLogiciellePorte arg2_in = modControledAcces.EntiteLogiciellePorteHelper.read(_is);
        String arg3_in = _is.read_string();

        try
        {
            modifierEmpreinte(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modControledAcces.EmpreinteExistante _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.EmpreinteExistanteHelper.write(_output,_exception);
        }
        catch (modControledAcces.CleInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.CleInconnueHelper.write(_output,_exception);
        }
        catch (modControledAcces.EmpreinteIncorrecte _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.EmpreinteIncorrecteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getCorrespondance(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            String _arg_result = getCorrespondance(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_string(_arg_result);

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

    private org.omg.CORBA.portable.OutputStream _invoke_verifierCorrespondance(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            verifierCorrespondance(arg0_in, arg1_in, arg2_in);

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
        catch (modControledAcces.EmpreinteIncorrecte _exception)
        {
            _output = handler.createExceptionReply();
            modControledAcces.EmpreinteIncorrecteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            supprimerEmpreinte(arg0_in, arg1_in);

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
        return _output;
    }

}
