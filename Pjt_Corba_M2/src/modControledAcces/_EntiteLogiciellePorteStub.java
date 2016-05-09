package modControledAcces;

/**
 * Interface definition : EntiteLogiciellePorte
 * 
 * @author OpenORB Compiler
 */
public class _EntiteLogiciellePorteStub extends org.omg.CORBA.portable.ObjectImpl
        implements EntiteLogiciellePorte
{
    static final String[] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogiciellePorte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modControledAcces.EntiteLogiciellePorteOperations.class;

    /**
     * Operation afficherMessage
     */
    public void afficherMessage()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("afficherMessage",true);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("afficherMessage",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    _self.afficherMessage();
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demandeEntrerSortirZone
     */
    public void demandeEntrerSortirZone(String idSal, String idZone)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeEntrerSortirZone",true);
                    _output.write_string(idSal);
                    _output.write_string(idZone);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeEntrerSortirZone",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    _self.demandeEntrerSortirZone( idSal,  idZone);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demanderAuthentifier
     */
    public String demanderAuthentifier(String photo, String empreinte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderAuthentifier",true);
                    _output.write_string(photo);
                    _output.write_string(empreinte);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderAuthentifier",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    return _self.demanderAuthentifier( photo,  empreinte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderModifierEmpreinte",true);
                    _output.write_string(idSal);
                    _output.write_string(empreinte);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderModifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    _self.demanderModifierEmpreinte( idSal,  empreinte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerPorte
     */
    public String creerPorte(String libellePorte, String idZone)
        throws modControledAcces.ErreurPorteExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerPorte",true);
                    _output.write_string(libellePorte);
                    _output.write_string(idZone);
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
                    if (_exception_id.equals(modControledAcces.ErreurPorteExistantHelper.id()))
                    {
                        throw modControledAcces.ErreurPorteExistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerPorte",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    return _self.creerPorte( libellePorte,  idZone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
