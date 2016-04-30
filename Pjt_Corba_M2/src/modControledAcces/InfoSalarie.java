package modControledAcces;

/**
 * Struct definition : InfoSalarie
 * 
 * @author OpenORB Compiler
*/
public final class InfoSalarie implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idSal
     */
    public String idSal;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member photo
     */
    public String photo;

    /**
     * Struct member empreinte
     */
    public String empreinte;

    /**
     * Struct member dateFinValidateCompte
     */
    public modControledAcces.Date dateFinValidateCompte;

    /**
     * Default constructor
     */
    public InfoSalarie()
    { }

    /**
     * Constructor with fields initialization
     * @param idSal idSal struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param photo photo struct member
     * @param empreinte empreinte struct member
     * @param dateFinValidateCompte dateFinValidateCompte struct member
     */
    public InfoSalarie(String idSal, String nom, String prenom, String photo, String empreinte, modControledAcces.Date dateFinValidateCompte)
    {
        this.idSal = idSal;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.empreinte = empreinte;
        this.dateFinValidateCompte = dateFinValidateCompte;
    }

}
