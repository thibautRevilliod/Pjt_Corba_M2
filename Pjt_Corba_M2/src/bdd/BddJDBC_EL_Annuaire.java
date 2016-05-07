package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modControledAcces.Date;
import modControledAcces.InfoSalarie;
import modControledAcces.InfoZone;

public class BddJDBC_EL_Annuaire {

	Connection conn;
	
	public BddJDBC_EL_Annuaire(String nomBD) {
		try {
		    Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
			
        	s.execute("create table IF NOT EXISTS Salaries  ( " +
        			" idSal INT NOT NULL PRIMARY KEY, " +
        			" mdp VARCHAR( 500 ), " +
        			" nom VARCHAR( 500 ), " + 
        			" prenom VARCHAR( 500 ), " +
        			" photo VARCHAR( 500 ) UNIQUE, " +
        			" heureDebut TimesTamp, " +
        			" heureFin TimesTamp, " +
        			" jourDebut TimesTamp, " +
        			" jourFin TimesTamp, " +
        			" dateFinValiditeCompte TIMESTAMP, " +
        			" estPermanent boolean )");
			
		} catch(Exception e) {
			// il y a eu une erreur
			e.printStackTrace();
		}
	}
	
	public static boolean clearBDD(String nomBD) {
		boolean res = true;
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
			Statement s = conn.createStatement();
			ResultSet rs = conn.getMetaData().getTables(null, null, "Salaries", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Salaries");
	        	res = true;
	        } else {	
	        	res = false;
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
	
	public String creerSalarie(String pmdp, String pnom, String pprenom, String pphoto, Timestamp pheureDebut, Timestamp pheureFin,
			Timestamp pjourDebut, Timestamp pjourFin, Timestamp pdateFinValiditeCompte, boolean pestPermanent) {
		String ids = "";
		int id = 0;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MAX(idSal) from salarie");
        	if (rs.next())
        	{
        		id = rs.getInt(1) + 1;
        	}
			rs = s.executeQuery("select photo from Salarie WHERE idSal = '"+pphoto+"'");
			if (!rs.next())
			{
				if(pheureDebut == null && pheureFin == null && pjourDebut == null && pjourFin == null)
				{
					s.executeUpdate("insert into Salarie (idSal,mdp,nom,prenom,photo,dateFinValiditeCompte,estPermanent) "
		        			+ "values ("+ids+", '"+pmdp+"', '"+pnom+"', '"+pprenom+"', '"+pphoto+"', {ts '"+pdateFinValiditeCompte+"'}, "+pestPermanent+")");
				}else
				{
		        	s.executeUpdate("insert into Salarie (idSal,mdp,nom,prenom,photo,heureDebut,heureFin,jourDebut,jourFin,dateFinValiditeCompte,estPermanent) "
		        			+ "values ("+ids+", '"+pmdp+"', '"+pnom+"', '"+pprenom+"', '"+pphoto+"', {ts '"+pheureDebut+"'}, {ts '"+pheureFin+"'}, {ts '"+pjourDebut+"'}, {ts '"+pjourFin+"'}, {ts '"+pdateFinValiditeCompte+"'}, "+pestPermanent+")");
				}
		        ids = String.valueOf(id);
			}
			else
			{
				ids = "-2"; // le cas ou le salarie existe déjà
			}
	        return ids;
		} catch (SQLException e) {
			e.printStackTrace();
			ids = "-1";
			return ids;
		}
	}
	
	public InfoSalarie infoSalarie(String pidSal) {
		InfoSalarie res = null;

		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal,mdp,nom,prenom,photo,dateFinValiditeCompte,estPermanent from Salarie where idSal = "+pidSal);
    		if(rs.next())
    		{
    			res = new InfoSalarie(String.valueOf(rs.getInt(1)),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new modControledAcces.Date(rs.getTimestamp(6).toString()), rs.getBoolean(7));
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	//liste zones
	public InfoSalarie[] listeTousSalaries() {
		InfoSalarie[] res = null;
		
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("select COUNT(*) FROM salaries ");

			if (rs.next())
        	{
				res = new InfoSalarie[rs.getInt(1)];
        	}
			
        	
			rs = s.executeQuery("select idSal, nom, prenom, photo, dateFinValiditeCompte,estPermanent from salaries");
			int i =0;
    		while(rs.next())
    		{
    			res[i] = new InfoSalarie(String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),new modControledAcces.Date(rs.getTimestamp(6).toString()), rs.getBoolean(7));
    			i++;
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public InfoSalarie infoSalarieNomPhoto(String pidSal) {
		InfoSalarie res = null;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select nom,photo,estPermanent from Salarie where idSal = "+pidSal);
    		if(rs.next())
    		{
    			res = new InfoSalarie(pidSal, rs.getString(1), "",rs.getString(2),"",null,rs.getBoolean(3));
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public String sauthentifier(String pphoto) {
		String res = "";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal from Salarie where photo = '"+pphoto+"'");
    		if(rs.next())
    		{
    			res = String.valueOf(rs.getInt(1));
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public void fermer() throws Exception {		
		try {
			conn.close();
		} catch(Exception ex) {
			// il y a eu une erreur
			ex.printStackTrace();
		}
	}
	
	public void init() {
		//salarie 1
			int jour = 15;
			int mois = 05;
			int annee = 2016;
			Calendar cal = GregorianCalendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, jour);
			cal.set(Calendar.MONTH, mois-1);// -1 as month is zero-based
			cal.set(Calendar.YEAR, annee);
			Timestamp tstamp = new Timestamp(cal.getTimeInMillis());
			creerSalarie("mdp1","nom1","prenom1","photo1",null,null,null,null,tstamp,true);	
		//salarie 2
			jour = 16;
			mois = 06;
			annee = 2016;
			cal = GregorianCalendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, jour);
			cal.set(Calendar.MONTH, mois-1);// -1 as month is zero-based
			cal.set(Calendar.YEAR, annee);
			tstamp = new Timestamp(cal.getTimeInMillis());
			creerSalarie("mdp2","nom2","prenom2","photo2",null,null,null,null,tstamp,true);	
	}
}