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
    public void demandeEntrerSortirZone(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
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
                    modControledAcces.EntiteLogiciellePorteHelper.write(_output,el_Porte);
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
                    _self.demandeEntrerSortirZone( idSal,  idZone,  el_Porte);
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
    public void demanderAuthentifier(String photo, modControledAcces.EntiteLogiciellePorte el_Porte)
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
                    modControledAcces.EntiteLogiciellePorteHelper.write(_output,el_Porte);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderAuthentifier",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogiciellePorteOperations _self = (modControledAcces.EntiteLogiciellePorteOperations) _so.servant;
                try
                {
                    _self.demanderAuthentifier( photo,  el_Porte);
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
     * Operation demanderModifierEmpreinte
     */
    public void demanderModifierEmpreinte(String idSal, String empreinte, modControledAcces.EntiteLogiciellePorte el_Porte)
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
                    modControledAcces.EntiteLogiciellePorteHelper.write(_output,el_Porte);
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
                    _self.demanderModifierEmpreinte( idSal,  empreinte,  el_Porte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
