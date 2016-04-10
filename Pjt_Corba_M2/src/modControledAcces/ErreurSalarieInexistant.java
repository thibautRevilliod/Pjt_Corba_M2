package modControledAcces;

/**
 * Exception definition : ErreurSalarieInexistant
 * 
 * @author OpenORB Compiler
 */
public final class ErreurSalarieInexistant extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonErreurSalarieInexistant
     */
    public String raisonErreurSalarieInexistant;

    /**
     * Default constructor
     */
    public ErreurSalarieInexistant()
    {
        super(ErreurSalarieInexistantHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonErreurSalarieInexistant raisonErreurSalarieInexistant exception member
     */
    public ErreurSalarieInexistant(String raisonErreurSalarieInexistant)
    {
        super(ErreurSalarieInexistantHelper.id());
        this.raisonErreurSalarieInexistant = raisonErreurSalarieInexistant;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonErreurSalarieInexistant raisonErreurSalarieInexistant exception member
     */
    public ErreurSalarieInexistant(String orb_reason, String raisonErreurSalarieInexistant)
    {
        super(ErreurSalarieInexistantHelper.id() +" " +  orb_reason);
        this.raisonErreurSalarieInexistant = raisonErreurSalarieInexistant;
    }

}
