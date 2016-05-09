package modControledAcces;

/**
 * Exception definition : ErreurPorteExistant
 * 
 * @author OpenORB Compiler
 */
public final class ErreurPorteExistant extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonErreurPorteExistant
     */
    public String raisonErreurPorteExistant;

    /**
     * Default constructor
     */
    public ErreurPorteExistant()
    {
        super(ErreurPorteExistantHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonErreurPorteExistant raisonErreurPorteExistant exception member
     */
    public ErreurPorteExistant(String raisonErreurPorteExistant)
    {
        super(ErreurPorteExistantHelper.id());
        this.raisonErreurPorteExistant = raisonErreurPorteExistant;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonErreurPorteExistant raisonErreurPorteExistant exception member
     */
    public ErreurPorteExistant(String orb_reason, String raisonErreurPorteExistant)
    {
        super(ErreurPorteExistantHelper.id() +" " +  orb_reason);
        this.raisonErreurPorteExistant = raisonErreurPorteExistant;
    }

}
