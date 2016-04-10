package modControledAcces;

/**
 * Exception definition : ErreurZoneInexistant
 * 
 * @author OpenORB Compiler
 */
public final class ErreurZoneInexistant extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonErreurZoneInexistant
     */
    public String raisonErreurZoneInexistant;

    /**
     * Default constructor
     */
    public ErreurZoneInexistant()
    {
        super(ErreurZoneInexistantHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonErreurZoneInexistant raisonErreurZoneInexistant exception member
     */
    public ErreurZoneInexistant(String raisonErreurZoneInexistant)
    {
        super(ErreurZoneInexistantHelper.id());
        this.raisonErreurZoneInexistant = raisonErreurZoneInexistant;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonErreurZoneInexistant raisonErreurZoneInexistant exception member
     */
    public ErreurZoneInexistant(String orb_reason, String raisonErreurZoneInexistant)
    {
        super(ErreurZoneInexistantHelper.id() +" " +  orb_reason);
        this.raisonErreurZoneInexistant = raisonErreurZoneInexistant;
    }

}
