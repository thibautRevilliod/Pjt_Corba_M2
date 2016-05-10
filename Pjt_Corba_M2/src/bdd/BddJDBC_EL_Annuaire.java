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
			ResultSet rs = s.executeQuery("select MAX(idSal) from Salaries");
        	if (rs.next())
        	{
        		id = rs.getInt(1) + 1;
        	}
			rs = s.executeQuery("select photo from Salaries WHERE photo = '"+pphoto+"'");
			if (!rs.next())
			{
				if(pestPermanent)
				{
					s.executeUpdate("insert into Salaries (idSal,mdp,nom,prenom,photo,dateFinValiditeCompte,estPermanent) "
		        			+ "values ("+id+", '"+pmdp+"', '"+pnom+"', '"+pprenom+"', '"+pphoto+"', {ts '"+pdateFinValiditeCompte+"'}, "+pestPermanent+")");
				}else
				{
		        	s.executeUpdate("insert into Salaries (idSal,mdp,nom,prenom,photo,heureDebut,heureFin,jourDebut,jourFin,dateFinValiditeCompte,estPermanent) "
		        			+ "values ("+id+", '"+pmdp+"', '"+pnom+"', '"+pprenom+"', '"+pphoto+"', {ts '"+pheureDebut+"'}, {ts '"+pheureFin+"'}, {ts '"+pjourDebut+"'}, {ts '"+pjourFin+"'}, {ts '"+pdateFinValiditeCompte+"'}, "+pestPermanent+")");
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
			ids = "";
			return ids;
		}
	}
	
	public InfoSalarie infoSalarie(String pidSal) {
		InfoSalarie res = null;

		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal,mdp,nom,prenom,photo,dateFinValiditeCompte,estPermanent from Salaries where idSal = "+pidSal);
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
    			res[i] = new InfoSalarie(String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),"",new modControledAcces.Date(rs.getTimestamp(5).toString()), rs.getBoolean(6));
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
			ResultSet rs = s.executeQuery("select nom,photo,estPermanent from Salaries where idSal = "+pidSal);
    		if(rs.next())
    		{
    			res = new InfoSalarie(pidSal, rs.getString(1), "",rs.getString(2),"",new modControledAcces.Date("") ,rs.getBoolean(3));
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public String sauthentifier(String pphoto, Timestamp dateHeureDde) {
		String res = "";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal,heureDebut,heureFin,jourDebut,jourFin,dateFinValiditeCompte,estPermanent from Salaries where photo = '"+pphoto+"'");
    		if(rs.next())
    		{
    			Timestamp dateFinValiditeCompte = rs.getTimestamp(6);
    			boolean estPermanent = rs.getBoolean(7);
    			if(!estPermanent)
    			{
    				if(dateHeureDde.before(dateFinValiditeCompte))
	    			{
						Timestamp jourDebut = rs.getTimestamp(4);
						Timestamp jourFin = rs.getTimestamp(5);
						Timestamp heureDebut = rs.getTimestamp(2);
						Timestamp heureFin = rs.getTimestamp(3);
						Calendar cal1 = GregorianCalendar.getInstance();
						Calendar cal2 = GregorianCalendar.getInstance();
						Calendar cal3 = GregorianCalendar.getInstance();
						
						//test des dates
						cal1.set(Calendar.DAY_OF_MONTH, dateHeureDde.getDay());
						cal1.set(Calendar.MONTH, dateHeureDde.getMonth());
						cal1.set(Calendar.YEAR, dateHeureDde.getYear());
						cal1.set(Calendar.HOUR_OF_DAY, 00);
						cal1.set(Calendar.MINUTE, 00);
						cal1.set(Calendar.SECOND, 00);
						
						cal2.set(Calendar.HOUR_OF_DAY, 00);
						cal2.set(Calendar.MINUTE, 00);
						cal2.set(Calendar.SECOND, 00);
						cal2.set(Calendar.DAY_OF_MONTH, jourDebut.getDay());
						cal2.set(Calendar.MONTH, jourDebut.getMonth());
						cal2.set(Calendar.YEAR, jourDebut.getYear());
		
						cal3.set(Calendar.HOUR_OF_DAY, 00);
						cal3.set(Calendar.MINUTE, 00);
						cal3.set(Calendar.SECOND, 00);
						cal3.set(Calendar.DAY_OF_MONTH, jourFin.getDay());
						cal3.set(Calendar.MONTH, jourFin.getMonth());
						cal3.set(Calendar.YEAR, jourFin.getYear());
			
						if((cal1.after(cal2) && cal1.before(cal3)) || (cal1.equals(cal2)) || (cal1.equals(cal3)))
						{
							//test des heures
							cal1.set(Calendar.HOUR, dateHeureDde.getHours());
							cal1.set(Calendar.MINUTE, dateHeureDde.getMinutes());
							cal1.set(Calendar.SECOND, dateHeureDde.getSeconds());
							cal1.set(Calendar.DAY_OF_MONTH, 10);
							cal1.set(Calendar.MONTH, 10);
							cal1.set(Calendar.YEAR, 2015);
							
							cal2.set(Calendar.HOUR, heureDebut.getHours());
							cal2.set(Calendar.MINUTE, heureDebut.getMinutes());
							cal2.set(Calendar.SECOND, heureDebut.getSeconds());
							cal2.set(Calendar.DAY_OF_MONTH, 10);
							cal2.set(Calendar.MONTH, 10);
							cal2.set(Calendar.YEAR, 2015);
		
							cal3.set(Calendar.HOUR, heureFin.getHours());
							cal3.set(Calendar.MINUTE, heureFin.getMinutes());
							cal3.set(Calendar.SECOND, heureFin.getSeconds());
							cal3.set(Calendar.DAY_OF_MONTH, 10);
							cal3.set(Calendar.MONTH, 10);
							cal3.set(Calendar.YEAR, 2015);
		
							if((cal1.after(cal2) && cal1.before(cal3)) || (cal1.equals(cal2)) || (cal1.equals(cal3)))
							{
								res = String.valueOf(rs.getInt(1));
							}
						}
	    			}
    			}else
    			{
    				res = String.valueOf(rs.getInt(1));
    			}
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BddJDBC_EL_Annuaire bddJDBC_EL_Annuaire = new BddJDBC_EL_Annuaire("BD_Annuaire");
		//bddJDBC_EL_Annuaire.init();
		
	//	bddJDBC_EL_Annuaire.listeTousSalaries();
		
		/*java.util.Date d = new java.util.Date();
		Timestamp tdate = new Timestamp(d.getTime());
		System.out.println(bddJDBC_EL_Annuaire.sauthentifier("photo1", tdate));*/
		
		System.out.println(bddJDBC_EL_Annuaire.infoSalarieNomPhoto("1").nom);
		
		try {
			bddJDBC_EL_Annuaire.fermer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}