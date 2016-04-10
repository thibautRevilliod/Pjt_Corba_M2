package modControledAcces;

/**
 * Exception definition : EmpreinteIncorrecte
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteIncorrecte extends org.omg.CORBA.UserException
{
    /**
     * Exception member raisonEmpreinteIncorrecte
     */
    public String raisonEmpreinteIncorrecte;

    /**
     * Default constructor
     */
    public EmpreinteIncorrecte()
    {
        super(EmpreinteIncorrecteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raisonEmpreinteIncorrecte raisonEmpreinteIncorrecte exception member
     */
    public EmpreinteIncorrecte(String raisonEmpreinteIncorrecte)
    {
        super(EmpreinteIncorrecteHelper.id());
        this.raisonEmpreinteIncorrecte = raisonEmpreinteIncorrecte;
    }

    /**
     * Full constructor with fields initialization
     * @param raisonEmpreinteIncorrecte raisonEmpreinteIncorrecte exception member
     */
    public EmpreinteIncorrecte(String orb_reason, String raisonEmpreinteIncorrecte)
    {
        super(EmpreinteIncorrecteHelper.id() +" " +  orb_reason);
        this.raisonEmpreinteIncorrecte = raisonEmpreinteIncorrecte;
    }

}
