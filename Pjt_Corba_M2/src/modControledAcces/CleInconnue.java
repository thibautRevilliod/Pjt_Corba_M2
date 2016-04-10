package modControledAcces;

/**
 * Exception definition : CleInconnue
 * 
 * @author OpenORB Compiler
 */
public final class CleInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonCleInconnue
     */
    public String raisonCleInconnue;

    /**
     * Default constructor
     */
    public CleInconnue()
    {
        super(CleInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonCleInconnue raisonCleInconnue exception member
     */
    public CleInconnue(String raisonCleInconnue)
    {
        super(CleInconnueHelper.id());
        this.raisonCleInconnue = raisonCleInconnue;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonCleInconnue raisonCleInconnue exception member
     */
    public CleInconnue(String orb_reason, String raisonCleInconnue)
    {
        super(CleInconnueHelper.id() +" " +  orb_reason);
        this.raisonCleInconnue = raisonCleInconnue;
    }

}
