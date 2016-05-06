package modControledAcces;

/**
 * Interface definition : EntiteLogicielleAnnuaire
 * 
 * @author OpenORB Compiler
 */
public class _EntiteLogicielleAnnuaireStub extends org.omg.CORBA.portable.ObjectImpl
        implements EntiteLogicielleAnnuaire
{
    static final String[] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleAnnuaire:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modControledAcces.EntiteLogicielleAnnuaireOperations.class;

    /**
     * Operation listeTousSalaries
     */
    public modControledAcces.InfoSalarie[] listeTousSalaries()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("listeTousSalaries",true);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarie[] _arg_ret = modControledAcces.ListeSalariesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("listeTousSalaries",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAnnuaireOperations _self = (modControledAcces.EntiteLogicielleAnnuaireOperations) _so.servant;
                try
                {
                    return _self.listeTousSalaries();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererNomPhotoSalarie
     */
    public modControledAcces.InfoSalarie recupererNomPhotoSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererNomPhotoSalarie",true);
                    _output.write_string(idSal);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarie _arg_ret = modControledAcces.InfoSalarieHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererNomPhotoSalarie",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAnnuaireOperations _self = (modControledAcces.EntiteLogicielleAnnuaireOperations) _so.servant;
                try
                {
                    return _self.recupererNomPhotoSalarie( idSal);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation infosSalarie
     */
    public modControledAcces.InfoSalarie infosSalarie(String idSal)
        throws modControledAcces.ErreurSalarieInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("infosSalarie",true);
                    _output.write_string(idSal);
                    _input = this._invoke(_output);
                    modControledAcces.InfoSalarie _arg_ret = modControledAcces.InfoSalarieHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("infosSalarie",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAnnuaireOperations _self = (modControledAcces.EntiteLogicielleAnnuaireOperations) _so.servant;
                try
                {
                    return _self.infosSalarie( idSal);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerSalarie
     */
    public String creerSalarie(String mdp, String nom, String prenom, String photo, modControledAcces.Date heureDebut, modControledAcces.Date heureFin, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date dateFinValiditeCompte, boolean estPermanent)
        throws modControledAcces.ErreurSalarieExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerSalarie",true);
                    _output.write_string(mdp);
                    _output.write_string(nom);
                    _output.write_string(prenom);
                    _output.write_string(photo);
                    modControledAcces.DateHelper.write(_output,heureDebut);
                    modControledAcces.DateHelper.write(_output,heureFin);
                    modControledAcces.DateHelper.write(_output,jourDebut);
                    modControledAcces.DateHelper.write(_output,jourFin);
                    modControledAcces.DateHelper.write(_output,dateFinValiditeCompte);
                    _output.write_boolean(estPermanent);
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
                    if (_exception_id.equals(modControledAcces.ErreurSalarieExistantHelper.id()))
                    {
                        throw modControledAcces.ErreurSalarieExistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerSalarie",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAnnuaireOperations _self = (modControledAcces.EntiteLogicielleAnnuaireOperations) _so.servant;
                try
                {
                    return _self.creerSalarie( mdp,  nom,  prenom,  photo,  heureDebut,  heureFin,  jourDebut,  jourFin,  dateFinValiditeCompte,  estPermanent);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation sauthentifier
     */
    public String sauthentifier(String photo)
        throws modControledAcces.ErreurSalarieInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("sauthentifier",true);
                    _output.write_string(photo);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("sauthentifier",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleAnnuaireOperations _self = (modControledAcces.EntiteLogicielleAnnuaireOperations) _so.servant;
                try
                {
                    return _self.sauthentifier( photo);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
