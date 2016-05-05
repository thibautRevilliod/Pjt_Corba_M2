package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modControledAcces.AccesZone;
import modControledAcces.EvenementJournalisation;
import modControledAcces.InfoZone;

public class BddJDBC_EL_Journalisation {

	Connection conn;
	
	public BddJDBC_EL_Journalisation(String nomBD) {
		try {
		    Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
			
	        s.execute("create table IF NOT EXISTS Acceder  ( " +
        			" idSal INT NOT NULL, " +
        			" idZone INT NOT NULL, " +
					" statuAcces boolean, " +
					" jourHeure TIMESTAMP , " +
					" operation VARCHAR( 500 ) , " +
					" contenuOperation VARCHAR( 500 ) , " +
					" PRIMARY KEY (idSal, idZone, jourHeure) )");

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
			ResultSet rs = conn.getMetaData().getTables(null, null, "Acceder", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Acceder");
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
	
	public void enregistrerEvenement(String pidSal, String pidZone, Boolean pstatuAcces, Timestamp pjourHeure, String poperation,String pcontenuOperation) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal,idZone,jourHeure from Acceder WHERE idZone = "+pidZone+" AND idSal = "+pidSal+" AND jourHeure = "+pjourHeure);
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Acceder (idSal,idZone,statuAcces,jourHeure,operation,contenuOperation) values ("+pidSal+", "+pidZone+", "+pstatuAcces+","+pjourHeure+",'"+poperation+"','"+pcontenuOperation+"'");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EvenementJournalisation[] consulterEvenement(String pidSal, String poperation, Timestamp pjourHeureDebut, Timestamp pjourHeureFin) {
		EvenementJournalisation[] res = null;
		AccesZone accesZone;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select count(*) from Acceder WHERE idSal = "+pidSal+" AND operation = "+poperation+" AND jourHeure BETWEEN "+pjourHeureDebut+" AND "+pjourHeureFin);

			if (rs.next())
        	{
				res = new EvenementJournalisation[rs.getInt(1)];
        	}
			
			rs = s.executeQuery("select idZone,statuAcces,jourHeure,operation,contenuOperation from Acceder WHERE idSal = "+pidSal+" AND operation = "+poperation+" AND jourHeure BETWEEN "+pjourHeureDebut+" AND "+pjourHeureFin);
			int i =0;
    		while(rs.next())
    		{
    			//TODO : modifier l'IDL en fonction !
    			//accesZone = new AccesZone(pidSal, String.valueOf(rs.getInt(1)), rs.getString(2), rs.getTimestamp(3));
    		//	res[i] = new EvenementJournalisation(accesZone, rs.getString(4),rs.getString(5));
    			i++;
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
		//journalisation 1
			int jour = 15;
			int mois = 05;
			int annee = 2016;
			int heure = 10;
			int minute = 42;
			int seconde = 10;
			Calendar cal = GregorianCalendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, jour);
			cal.set(Calendar.MONTH, mois-1);// -1 as month is zero-based
			cal.set(Calendar.YEAR, annee);
			Timestamp tstamp = new Timestamp(cal.getTimeInMillis());
			enregistrerEvenement("1", "1", true, tstamp, "entree", "blabla");	
		//journalisation 2
			jour = 16;
			mois = 05;
			annee = 2016;
			heure = 9;
			minute = 00;
			seconde = 00;
			cal = GregorianCalendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, jour);
			cal.set(Calendar.MONTH, mois-1);// -1 as month is zero-based
			cal.set(Calendar.YEAR, annee);
			cal.set(Calendar.HOUR_OF_DAY, heure);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, seconde);
			tstamp = new Timestamp(cal.getTimeInMillis());
			enregistrerEvenement("1", "1", true, tstamp, "sortie", "blabla");	
	}
}
