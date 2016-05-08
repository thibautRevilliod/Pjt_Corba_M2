package modControledAcces;

/**
 * Interface definition : EntiteLogicielleJournalisation
 * 
 * @author OpenORB Compiler
 */
public class _EntiteLogicielleJournalisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements EntiteLogicielleJournalisation
{
    static final String[] _ids_list =
    {
        "IDL:modControledAcces/EntiteLogicielleJournalisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modControledAcces.EntiteLogicielleJournalisationOperations.class;

    /**
     * Operation listeOperations
     */
    public modControledAcces.InfoOperation[] listeOperations()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("listeOperations",true);
                    _input = this._invoke(_output);
                    modControledAcces.InfoOperation[] _arg_ret = modControledAcces.ListeOperationsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("listeOperations",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleJournalisationOperations _self = (modControledAcces.EntiteLogicielleJournalisationOperations) _so.servant;
                try
                {
                    return _self.listeOperations();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulter
     */
    public modControledAcces.EvenementJournalisation[] consulter(String qui, String quoi, String quand_debut, String quand_fin, String cleDemandeur)
        throws modControledAcces.CleInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulter",true);
                    _output.write_string(qui);
                    _output.write_string(quoi);
                    _output.write_string(quand_debut);
                    _output.write_string(quand_fin);
                    _output.write_string(cleDemandeur);
                    _input = this._invoke(_output);
                    modControledAcces.EvenementJournalisation[] _arg_ret = modControledAcces.ListeEvenementsJournalisationHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulter",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleJournalisationOperations _self = (modControledAcces.EntiteLogicielleJournalisationOperations) _so.servant;
                try
                {
                    return _self.consulter( qui,  quoi,  quand_debut,  quand_fin,  cleDemandeur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerEvenement
     */
    public void enregistrerEvenement(modControledAcces.EvenementJournalisation evenementJournalisation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerEvenement",true);
                    modControledAcces.EvenementJournalisationHelper.write(_output,evenementJournalisation);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerEvenement",_opsClass);
                if (_so == null)
                   continue;
                modControledAcces.EntiteLogicielleJournalisationOperations _self = (modControledAcces.EntiteLogicielleJournalisationOperations) _so.servant;
                try
                {
                    _self.enregistrerEvenement( evenementJournalisation);
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
