package modControledAcces;

/**
 * Interface definition : EntiteLogicielleEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class _EntiteLogicielleEmpreinteStub extends org.omg.CORBA.portable.ObjectImpl
        implements EntiteLogicielleEmpreinte
{
    static final String[] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleEmpreinte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modControledAcces.EntiteLogicielleEmpreinteOperations.class;

    /**
     * Operation ajouterEmpreinte
     */
    public String ajouterEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterEmpreinte",true);
                    _output.write_string(idSal);
                    _output.write_string(empreinte);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modControledAcces.EmpreinteExistanteHelper.id()))
                    {
                        throw modControledAcces.EmpreinteExistanteHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.EmpreinteIncorrecteHelper.id()))
                    {
                        throw modControledAcces.EmpreinteIncorrecteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleEmpreinteOperations _self = (modControledAcces.EntiteLogicielleEmpreinteOperations) _so.servant;
                try
                {
                    return _self.ajouterEmpreinte( idSal,  empreinte,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierEmpreinte
     */
    public String modifierEmpreinte(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.EmpreinteExistante, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierEmpreinte",true);
                    _output.write_string(idSal);
                    _output.write_string(empreinte);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modControledAcces.EmpreinteExistanteHelper.id()))
                    {
                        throw modControledAcces.EmpreinteExistanteHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.EmpreinteIncorrecteHelper.id()))
                    {
                        throw modControledAcces.EmpreinteIncorrecteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleEmpreinteOperations _self = (modControledAcces.EntiteLogicielleEmpreinteOperations) _so.servant;
                try
                {
                    return _self.modifierEmpreinte( idSal,  empreinte,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getCorrespondance
     */
    public String getCorrespondance(String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCorrespondance",true);
                    _output.write_string(empreinte);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modControledAcces.ErreurSalarieInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurSalarieInexistantHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCorrespondance",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleEmpreinteOperations _self = (modControledAcces.EntiteLogicielleEmpreinteOperations) _so.servant;
                try
                {
                    return _self.getCorrespondance( empreinte,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierCorrespondance
     */
    public boolean verifierCorrespondance(String idSal, String empreinte, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.EmpreinteIncorrecte
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierCorrespondance",true);
                    _output.write_string(idSal);
                    _output.write_string(empreinte);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modControledAcces.ErreurSalarieInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurSalarieInexistantHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.EmpreinteIncorrecteHelper.id()))
                    {
                        throw modControledAcces.EmpreinteIncorrecteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierCorrespondance",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleEmpreinteOperations _self = (modControledAcces.EntiteLogicielleEmpreinteOperations) _so.servant;
                try
                {
                    return _self.verifierCorrespondance( idSal,  empreinte,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerEmpreinte
     */
    public String supprimerEmpreinte(String idSal, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerEmpreinte",true);
                    _output.write_string(idSal);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modControledAcces.ErreurSalarieInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurSalarieInexistantHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleEmpreinteOperations _self = (modControledAcces.EntiteLogicielleEmpreinteOperations) _so.servant;
                try
                {
                    return _self.supprimerEmpreinte( idSal,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
