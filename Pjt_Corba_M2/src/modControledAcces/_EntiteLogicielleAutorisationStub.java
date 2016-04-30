package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAutorisation
 * 
 * @author OpenORB Compiler
 */
public class _EntiteLogicielleAutorisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements EntiteLogicielleAutorisation
{
    static final String[] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleAutorisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modControledAcces.EntiteLogicielleAutorisationOperations.class;

    /**
     * Operation listeToutesZones
     */
    public modControledAcces.InfoZone[] listeToutesZones()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("listeToutesZones",true);
                    _input = this._invoke(_output);
                    modControledAcces.InfoZone[] _arg_ret = modControledAcces.ListeZonesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("listeToutesZones",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    return _self.listeToutesZones();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String idSal, String idZone, modControledAcces.EntiteLogiciellePorte el_Porte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAutorisation",true);
                    _output.write_string(idSal);
                    _output.write_string(idZone);
                    modControledAcces.EntiteLogiciellePorteHelper.write(_output,el_Porte);
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

                    if (_exception_id.equals(modControledAcces.ErreurZoneInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurZoneInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAutorisation",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    return _self.verifierAutorisation( idSal,  idZone,  el_Porte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerAccreditation
     */
    public void creerAccreditation(String idSal, String idZone, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, String cleDemandeur)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.CleInconnue, modControledAcces.ErreurZoneInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerAccreditation",true);
                    _output.write_string(idSal);
                    _output.write_string(idZone);
                    modControledAcces.DateHelper.write(_output,jourDebut);
                    modControledAcces.DateHelper.write(_output,jourFin);
                    modControledAcces.DateHelper.write(_output,heureDebut);
                    modControledAcces.DateHelper.write(_output,heureFin);
                    _output.write_string(cleDemandeur);
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
                    if (_exception_id.equals(modControledAcces.ErreurSalarieInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurSalarieInexistantHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.CleInconnueHelper.id()))
                    {
                        throw modControledAcces.CleInconnueHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(modControledAcces.ErreurZoneInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurZoneInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerAccreditation",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    _self.creerAccreditation( idSal,  idZone,  jourDebut,  jourFin,  heureDebut,  heureFin,  cleDemandeur);
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
     * Operation lireAccreditationSalarie
     */
    public modControledAcces.InfoSalarieAccreditation lireAccreditationSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("lireAccreditationSalarie",true);
                    _output.write_string(idSal);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarieAccreditation _arg_ret = modControledAcces.InfoSalarieAccreditationHelper.read(_input);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("lireAccreditationSalarie",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    return _self.lireAccreditationSalarie( idSal);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation modifierAccreditation(String idSal, String idZone, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierAccreditation",true);
                    _output.write_string(idSal);
                    _output.write_string(idZone);
                    modControledAcces.DateHelper.write(_output,jourDebut);
                    modControledAcces.DateHelper.write(_output,jourFin);
                    modControledAcces.DateHelper.write(_output,heureDebut);
                    modControledAcces.DateHelper.write(_output,heureFin);
                    modControledAcces.EntiteLogicielleEmpreinteHelper.write(_output,el_Empreinte);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarieAccreditation _arg_ret = modControledAcces.InfoSalarieAccreditationHelper.read(_input);
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

                    if (_exception_id.equals(modControledAcces.ErreurZoneInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurZoneInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierAccreditation",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    return _self.modifierAccreditation( idSal,  idZone,  jourDebut,  jourFin,  heureDebut,  heureFin,  el_Empreinte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerAccreditation
     */
    public modControledAcces.InfoSalarieAccreditation supprimerAccreditation(String idSal, String idZone, modControledAcces.EntiteLogicielleEmpreinte el_Empreinte)
        throws modControledAcces.ErreurSalarieInexistant, modControledAcces.ErreurZoneInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAccreditation",true);
                    _output.write_string(idSal);
                    _output.write_string(idZone);
                    modControledAcces.EntiteLogicielleEmpreinteHelper.write(_output,el_Empreinte);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarieAccreditation _arg_ret = modControledAcces.InfoSalarieAccreditationHelper.read(_input);
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

                    if (_exception_id.equals(modControledAcces.ErreurZoneInexistantHelper.id()))
                    {
                        throw modControledAcces.ErreurZoneInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAccreditation",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAutorisationOperations _self = (modControledAcces.EntiteLogicielleAutorisationOperations) _so.servant;
                try
                {
                    return _self.supprimerAccreditation( idSal,  idZone,  el_Empreinte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
