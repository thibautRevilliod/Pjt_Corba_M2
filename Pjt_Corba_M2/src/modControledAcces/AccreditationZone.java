package modControledAcces;

/**
 * Struct definition : AccreditationZone
 * 
 * @author OpenORB Compiler
*/
public final class AccreditationZone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZone
     */
    public String idZone;

    /**
     * Struct member dateAcreditation
     */
    public modControledAcces.Date dateAcreditation;

    /**
     * Struct member jourDebut
     */
    public modControledAcces.Date jourDebut;

    /**
     * Struct member jourFin
     */
    public modControledAcces.Date jourFin;

    /**
     * Struct member heureDebut
     */
    public modControledAcces.Date heureDebut;

    /**
     * Struct member heureFin
     */
    public modControledAcces.Date heureFin;

    /**
     * Default constructor
     */
    public AccreditationZone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param dateAcreditation dateAcreditation struct member
     * @param jourDebut jourDebut struct member
     * @param jourFin jourFin struct member
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     */
    public AccreditationZone(String idZone, modControledAcces.Date dateAcreditation, modControledAcces.Date jourDebut, modControledAcces.Date jourFin, modControledAcces.Date heureDebut, modControledAcces.Date heureFin)
    {
        this.idZone = idZone;
        this.dateAcreditation = dateAcreditation;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

}
