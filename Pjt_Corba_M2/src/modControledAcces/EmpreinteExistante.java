package modControledAcces;

/**
 * Exception definition : EmpreinteExistante
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonEmpreinteExistante
     */
    public String raisonEmpreinteExistante;

    /**
     * Default constructor
     */
    public EmpreinteExistante()
    {
        super(EmpreinteExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonEmpreinteExistante raisonEmpreinteExistante exception member
     */
    public EmpreinteExistante(String raisonEmpreinteExistante)
    {
        super(EmpreinteExistanteHelper.id());
        this.raisonEmpreinteExistante = raisonEmpreinteExistante;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonEmpreinteExistante raisonEmpreinteExistante exception member
     */
    public EmpreinteExistante(String orb_reason, String raisonEmpreinteExistante)
    {
        super(EmpreinteExistanteHelper.id() +" " +  orb_reason);
        this.raisonEmpreinteExistante = raisonEmpreinteExistante;
    }

}
