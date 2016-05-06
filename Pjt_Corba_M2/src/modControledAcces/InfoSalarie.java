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
     * Struct member dateFinValiditeCompte
     */
    public modControledAcces.Date dateFinValiditeCompte;

    /**
     * Struct member estPermanent
     */
    public boolean estPermanent;

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
     * @param dateFinValiditeCompte dateFinValiditeCompte struct member
     * @param estPermanent estPermanent struct member
     */
    public InfoSalarie(String idSal, String nom, String prenom, String photo, String empreinte, modControledAcces.Date dateFinValiditeCompte, boolean estPermanent)
    {
        this.idSal = idSal;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.empreinte = empreinte;
        this.dateFinValiditeCompte = dateFinValiditeCompte;
        this.estPermanent = estPermanent;
    }

}
