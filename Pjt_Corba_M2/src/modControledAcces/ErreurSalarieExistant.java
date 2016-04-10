package modControledAcces;

/**
 * Exception definition : ErreurSalarieExistant
 * 
 * @author OpenORB Compiler
 */
public final class ErreurSalarieExistant extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonErreurSalarieExistant
     */
    public String raisonErreurSalarieExistant;

    /**
     * Default constructor
     */
    public ErreurSalarieExistant()
    {
        super(ErreurSalarieExistantHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonErreurSalarieExistant raisonErreurSalarieExistant exception member
     */
    public ErreurSalarieExistant(String raisonErreurSalarieExistant)
    {
        super(ErreurSalarieExistantHelper.id());
        this.raisonErreurSalarieExistant = raisonErreurSalarieExistant;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonErreurSalarieExistant raisonErreurSalarieExistant exception member
     */
    public ErreurSalarieExistant(String orb_reason, String raisonErreurSalarieExistant)
    {
        super(ErreurSalarieExistantHelper.id() +" " +  orb_reason);
        this.raisonErreurSalarieExistant = raisonErreurSalarieExistant;
    }

}
