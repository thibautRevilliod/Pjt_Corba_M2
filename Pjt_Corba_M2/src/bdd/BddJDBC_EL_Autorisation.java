package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modControledAcces.AccreditationZone;
import modControledAcces.InfoSalarieAccreditation;
import modControledAcces.InfoZone;

public class BddJDBC_EL_Autorisation {

	Connection conn;
	
	public BddJDBC_EL_Autorisation(String nomBD) {
		try {
		    Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
			
        	s.execute("create table IF NOT EXISTS Zones  ( " +
        			" idZone int NOT NULL PRIMARY KEY, " +
        			" libelleZone VARCHAR( 500 ) UNIQUE )");

        	s.execute("create table IF NOT EXISTS Accrediter  ( " +
        			" idSal int NOT NULL, " +
        			" idZone int NOT NULL, " +
        			" dateAccreditation TIMESTAMP , " +
					" jourDebut TIMESTAMP , " +
        			" jourFin TIMESTAMP , " +
					" heureDebut TIMESTAMP , " +
					" heureFin TIMESTAMP , " +
					" PRIMARY KEY (idSal, idZone) , " +
					" FOREIGN KEY (idZone) REFERENCES Zones(idZone))");
			
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
	        
	        ResultSet rs = conn.getMetaData().getTables(null, null, "Accrediter", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Accrediter");
	        	res = true;
	        } else {	
	        	res = false;
	        }
	        
	        rs = conn.getMetaData().getTables(null, null, "Zones", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Zones");
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
	
	public String creerZone(String pidZone, String plibelleZone) {	
		String idz = "";
		int id = 0;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MAX(idZone) from zones");
        	if (rs.next())
        	{
        		id = rs.getInt(1) + 1;
        	}
			rs = s.executeQuery("select libelleZone from zones WHERE libelleZone = '"+plibelleZone+"'");
			if (!rs.next())
			{
				s.executeUpdate("insert into Zones (idZone,libelleZone) values ("+idz+", '"+plibelleZone+"')");
				idz = String.valueOf(id);
			}
			else
			{
				idz = "-2"; // le cas ou l'empreinte existe déjà
			}
	        return idz;
		} catch (SQLException e) {
			e.printStackTrace();
			idz = "-1";
			return idz;
		}
	}
	
	public int creerAccrediter(String pidSal, String pidZone, Timestamp pdateAccreditation, Timestamp pjourDebut, Timestamp pjourFin, Timestamp pheureDebut,Timestamp pheureFin) {
		int id = 0;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select dateAccreditation from Accrediter WHERE idZone = "+pidZone+" AND idSal = "+pidSal+"");
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Accrediter (idSal,idZone,dateAccreditation,jourDebut,jourFin,heureDebut,heureFin) values ("+pidSal+", "+pidZone+", {ts '"+pdateAccreditation+"'}, {ts '"+pjourDebut+"'},{ts '"+pjourFin+"'},{ts '"+pheureDebut+"'},{ts '"+pheureFin+"'})");
			}
			else
			{
				id = -2; // le cas ou l'accreditation existe déjà
			}
	        return id;
		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
		}
	}
	
//	public int creerAcceder(String pidSal, String pidZone, Date pdateDdeAcces, Boolean pstatuAcces, Timestamp pjourEntree, Timestamp pjourSortie,Timestamp pheureEntree,Timestamp pheureSortie) {
//		int id = 0;
//		try {
//			Statement s = conn.createStatement();
//			ResultSet rs = s.executeQuery("select dateDdeAcces from Acceder WHERE idZone = '"+pidZone+"' AND idSal = '"+pidSal+"'");
//			if (!rs.next())
//			{
//	        	s.executeUpdate("insert into Acceder (idSal,idZone,dateDdeAcces,pstatuAcces,pjourEntree,pjourSortie,pheureEntree,pheureSortie) values ('"+pidSal+"', '"+pidZone+"', "+pdateDdeAcces+", "+pstatuAcces+","+pjourEntree+","+pjourSortie+","+pheureEntree+","+pheureSortie+"");
//			}
//			else
//			{
//				id = -2; // le cas ou l'Acceder existe déjà
//			}
//	        return id;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			id = -1;
//			return id;
//		}
//	}
	
	public InfoSalarieAccreditation supprimerAccreditation(String pidSal, String pidZone) {
		InfoSalarieAccreditation res = null;
		AccreditationZone[] accreditationZone = null;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT idSal,idZone FROM Accrediter WHERE idZone = "+pidZone+" AND idSal = "+pidSal+"");
        	if (rs.next())
        	{
        		s.executeUpdate("DELETE FROM Accrediter WHERE idZone = "+pidZone+" AND idSal = "+pidSal+"");
        	}
        	
        	//retourne les droits qui restent au salarié
        	rs = s.executeQuery("SELECT COUNT(*) FROM Accrediter WHERE idSal = "+pidSal+"");

			if (rs.next())
        	{
				accreditationZone = new AccreditationZone[rs.getInt(1)];
        	}
			
			rs = s.executeQuery("select idZone, dateAccreditation, jourDebut, jourFin, heureDebut, heureFin from Zones");
			int i =0;
    		while(rs.next())
    		{
    			accreditationZone[i] = new AccreditationZone(String.valueOf(rs.getInt(1)),new modControledAcces.Date(rs.getTimestamp(2).toString()), new modControledAcces.Date(rs.getTimestamp(3).toString()), new modControledAcces.Date(rs.getTimestamp(4).toString()),new modControledAcces.Date(rs.getTimestamp(5).toString()), new modControledAcces.Date(rs.getTimestamp(6).toString()));
    			i++;
    		}
        	res = new InfoSalarieAccreditation(pidSal,accreditationZone);
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public InfoSalarieAccreditation modifierAccreditation(String pidSal, String pidZone, Timestamp pjourDebut, Timestamp pjourFin, Timestamp pheureDebut, Timestamp pheureFin) {
		InfoSalarieAccreditation res = null;
		AccreditationZone[] accreditationZone = null;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT idSal,idZone FROM Accrediter WHERE idZone = "+pidZone+" AND idSal = "+pidSal+"");
        	if (rs.next())
        	{
        		java.util.Date d = new java.util.Date();
    			Timestamp tdate = new Timestamp(d.getTime());
        		s.executeUpdate("UPDATE Accrediter SET jourDebut = {ts '"+pjourDebut+"'}, jourFin = {ts '"+pjourFin+"'}, heureDebut = {ts '"+pheureDebut+"'}, heureFin = {ts '"+pheureFin+"'}, dateAccreditation = {ts '"+tdate+"'} WHERE idZone = "+pidZone+" AND idSal = "+pidSal+"");
        	}
        	
        	//retourne les droits qui restent au salarié
        	rs = s.executeQuery("SELECT COUNT(*) FROM Accrediter WHERE idSal = "+pidSal+"");

			if (rs.next())
        	{
				accreditationZone = new AccreditationZone[rs.getInt(1)];
        	}
			
			rs = s.executeQuery("select idZone, dateAccreditation, jourDebut, jourFin, heureDebut, heureFin from Zones");
			int i =0;
    		while(rs.next())
    		{
    			accreditationZone[i] = new AccreditationZone(String.valueOf(rs.getInt(1)),new modControledAcces.Date(rs.getTimestamp(2).toString()), new modControledAcces.Date(rs.getTimestamp(3).toString()), new modControledAcces.Date(rs.getTimestamp(4).toString()),new modControledAcces.Date(rs.getTimestamp(5).toString()), new modControledAcces.Date(rs.getTimestamp(6).toString()));
    			i++;
    		}
        	res = new InfoSalarieAccreditation(pidSal,accreditationZone);
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public InfoSalarieAccreditation lireAccreditation(String pidSal) {
		InfoSalarieAccreditation res = null;
		AccreditationZone[] accreditationZone = null;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM Accrediter WHERE idSal = "+pidSal+"");

			if (rs.next())
        	{
				accreditationZone = new AccreditationZone[rs.getInt(1)];
        	}
			
			rs = s.executeQuery("select idZone, dateAccreditation, jourDebut, jourFin, heureDebut, heureFin from Zones");
			int i =0;
    		while(rs.next())
    		{
    			accreditationZone[i] = new AccreditationZone(String.valueOf(rs.getInt(1)),new modControledAcces.Date(rs.getTimestamp(2).toString()), new modControledAcces.Date(rs.getTimestamp(3).toString()), new modControledAcces.Date(rs.getTimestamp(4).toString()),new modControledAcces.Date(rs.getTimestamp(5).toString()), new modControledAcces.Date(rs.getTimestamp(6).toString()));
    			i++;
    		}
        	res = new InfoSalarieAccreditation(pidSal,accreditationZone);
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public boolean verifierAutorisation(String pidSal, String pidZone, Timestamp dateHeureDde) {
		//Timestamp dateHeureDde <=> à la date de la demande actuelle pour vérifier son droit d'accès à la zone
		boolean res = false;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT jourDebut, jourFin, heureDebut, heureFin FROM Accrediter WHERE idSal = "+pidSal+" AND idZone = "+pidZone);

			if (rs.next())
        	{
				Timestamp jourDebut = rs.getTimestamp(1);
				Timestamp jourFin = rs.getTimestamp(2);
				Timestamp heureDebut = rs.getTimestamp(3);
				Timestamp heureFin = rs.getTimestamp(4);
				Calendar cal1 = GregorianCalendar.getInstance();
				Calendar cal2 = GregorianCalendar.getInstance();
				Calendar cal3 = GregorianCalendar.getInstance();
				
				//test des dates
				cal1.setTimeInMillis(dateHeureDde.getTime());
				cal1.set(Calendar.HOUR_OF_DAY, 00);
				cal1.set(Calendar.MINUTE, 00);
				cal1.set(Calendar.SECOND, 00);
				cal2.setTimeInMillis(jourDebut.getTime());
				cal2.set(Calendar.HOUR_OF_DAY, 00);
				cal2.set(Calendar.MINUTE, 00);
				cal2.set(Calendar.SECOND, 00);
				cal3.setTimeInMillis(jourFin.getTime());
				cal3.set(Calendar.HOUR_OF_DAY, 00);
				cal3.set(Calendar.MINUTE, 00);
				cal3.set(Calendar.SECOND, 00);

				if(cal1.after(cal2) && cal1.before(cal3))
				{
					//test des heures
					cal1.setTimeInMillis(dateHeureDde.getTime());
					cal1.set(Calendar.DAY_OF_MONTH, 10);
					cal1.set(Calendar.MONTH, 10);
					cal1.set(Calendar.YEAR, 2015);
					cal2.setTimeInMillis(heureDebut.getTime());
					cal2.set(Calendar.DAY_OF_MONTH, 10);
					cal2.set(Calendar.MONTH, 10);
					cal2.set(Calendar.YEAR, 2015);
					cal3.setTimeInMillis(heureFin.getTime());
					cal3.set(Calendar.DAY_OF_MONTH, 10);
					cal3.set(Calendar.MONTH, 10);
					cal3.set(Calendar.YEAR, 2015);
					
					if(cal1.after(cal2) && cal1.before(cal3))
					{
						res = true;
					}
				}
        	}
					
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}

	//liste zones
	public InfoZone[] listeZones() {
		InfoZone[] res = null;
		
		try {
			Statement s = conn.createStatement();
			//récupère le dernier ID
			ResultSet rs = s.executeQuery("select COUNT(*) FROM Zones ");

			if (rs.next())
        	{
				res = new InfoZone[rs.getInt(1)];
        	}
        	//récupère le dernier ID
			rs = s.executeQuery("select idZone, libelleZone from Zones");
			int i =0;
    		while(rs.next())
    		{
    			res[i] = new InfoZone(String.valueOf(rs.getInt(1)),rs.getString(2));
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
		//zones
			creerZone("1", "Zone1");
			creerZone("2", "Zone2");
			creerZone("3", "Zone3");
			creerZone("4", "Zone4");	
		//accreditations
			//accreditation1
				//cal1 : pdateAccreditation
				Calendar cal1 = GregorianCalendar.getInstance();
				cal1.set(Calendar.DAY_OF_MONTH, 05);
				cal1.set(Calendar.MONTH, 05-1);// -1 as month is zero-based
				cal1.set(Calendar.YEAR, 2016);
				Timestamp tstamp1 = new Timestamp(cal1.getTimeInMillis());
				//cal2 : pjourDebut
				Calendar cal2 = GregorianCalendar.getInstance();
				cal2.set(Calendar.DAY_OF_MONTH, 06);
				cal2.set(Calendar.MONTH, 05-1);// -1 as month is zero-based
				cal2.set(Calendar.YEAR, 2016);
				Timestamp tstamp2 = new Timestamp(cal2.getTimeInMillis());
				//cal3 : pjourFin
				Calendar cal3 = GregorianCalendar.getInstance();
				cal3.set(Calendar.DAY_OF_MONTH, 25);
				cal3.set(Calendar.MONTH, 06-1);// -1 as month is zero-based
				cal3.set(Calendar.YEAR, 2016);
				Timestamp tstamp3 = new Timestamp(cal3.getTimeInMillis());
				//cal4 : pheureDebut
				Calendar cal4 = GregorianCalendar.getInstance();
				cal4.set(Calendar.HOUR_OF_DAY, 8);
				cal4.set(Calendar.MINUTE, 00);
				cal4.set(Calendar.SECOND, 00);
				Timestamp tstamp4 = new Timestamp(cal4.getTimeInMillis());
				//cal5 : pheureFin
				Calendar cal5 = GregorianCalendar.getInstance();
				cal5.set(Calendar.HOUR_OF_DAY, 17);
				cal5.set(Calendar.MINUTE, 00);
				cal5.set(Calendar.SECOND, 00);
				Timestamp tstamp5 = new Timestamp(cal5.getTimeInMillis());
				creerAccrediter("1", "1", tstamp1, tstamp2, tstamp3, tstamp4, tstamp5);
			//accreditation2
				//cal1 : pdateAccreditation
				cal1 = GregorianCalendar.getInstance();
				cal1.set(Calendar.DAY_OF_MONTH, 05);
				cal1.set(Calendar.MONTH, 05-1);// -1 as month is zero-based
				cal1.set(Calendar.YEAR, 2016);
				tstamp1 = new Timestamp(cal1.getTimeInMillis());
				//cal2 : pjourDebut
				cal2 = GregorianCalendar.getInstance();
				cal2.set(Calendar.DAY_OF_MONTH, 16);
				cal2.set(Calendar.MONTH, 05-1);// -1 as month is zero-based
				cal2.set(Calendar.YEAR, 2016);
				tstamp2 = new Timestamp(cal2.getTimeInMillis());
				//cal3 : pjourFin
				cal3 = GregorianCalendar.getInstance();
				cal3.set(Calendar.DAY_OF_MONTH, 21);
				cal3.set(Calendar.MONTH, 05-1);// -1 as month is zero-based
				cal3.set(Calendar.YEAR, 2016);
				tstamp3 = new Timestamp(cal3.getTimeInMillis());
				//cal4 : pheureDebut
				cal4 = GregorianCalendar.getInstance();
				cal4.set(Calendar.HOUR_OF_DAY, 9);
				cal4.set(Calendar.MINUTE, 00);
				cal4.set(Calendar.SECOND, 00);
				tstamp4 = new Timestamp(cal4.getTimeInMillis());
				//cal5 : pheureFin
				cal5 = GregorianCalendar.getInstance();
				cal5.set(Calendar.HOUR_OF_DAY, 18);
				cal5.set(Calendar.MINUTE, 00);
				cal5.set(Calendar.SECOND, 00);
				tstamp5 = new Timestamp(cal5.getTimeInMillis());
				creerAccrediter("2", "2", tstamp1, tstamp2, tstamp3, tstamp4, tstamp5);
	}
	
	/*
	public static void main(String[] args) throws Exception {
		JmsJDBC.clearBDD("JMS");
		JmsJDBC bdd = new JmsJDBC("JMS");
		
		System.out.println(" Création des profils : ");
			System.out.println("Profil n°: " + bdd.creerProfil("patoche", "mdp", "Sébastien", "Patrick", "Paris"));
			System.out.println("Profil n°: " +bdd.creerProfil("mimie", "mdp", "Mathy", "Mimie", "Rennes"));
			System.out.println("Profil n°: " +bdd.creerProfil("claire", "mdp", "Chazal", "Claire", "Rennes"));
			System.out.println(" --> OK");
		System.out.println(" Création des Gazouilli : ");
			//récupère la dateHeure
	    	Date date= new Date();
			Timestamp time = new Timestamp(date.getTime());
			System.out.println("gazouilli n°: " + bdd.creerGazouilli("Bonjour je suis patoche", "patoche", time, false));
			System.out.println("gazouilli n°: " + bdd.creerGazouilli("Bonjour je suis patoche de Paris", "patoche", time, true));
			System.out.println("gazouilli n°: " + bdd.creerGazouilli("Bonjour je suis mimie", "mimie", time, false));
			System.out.println("gazouilli n°: " + bdd.creerGazouilli("Bonjour je suis claire", "claire", time, false));
			System.out.println(" --> OK");
		
		System.out.println("--> Vérification mdp : " + bdd.verificationIDMDP("patoche", "mdp"));
		System.out.println("--> Information profil : ");
			ProfilType profil = bdd.informationProfil("patoche");
			System.out.println("     " + profil.getPSEUDO() + " " + profil.getNOM() + " " + profil.getPRENOM() + " " + profil.getVILLE());
		
		System.out.println("--> Création Abonnement : " + bdd.creerAbonnement("patoche", "mimie"));
		System.out.println("--> Création Abonnement : " + bdd.creerAbonnement("mimie", "patoche"));
		System.out.println("--> Création Abonnement : " + bdd.creerAbonnement("claire", "mimie"));
		
		System.out.println("--> Liste Abonne : ");
			System.out.print("     ");
			for(int i = 0; i < bdd.listeAbonne("mimie").size(); i++)
			{
				System.out.print(bdd.listeAbonne("mimie").get(i) + " ");
			}
			System.out.println("");
			
		System.out.println("--> Liste Suivi : ");
			System.out.print("     ");
			for(int i = 0; i < bdd.listeSuivi("mimie").size(); i++)
			{
				System.out.print(bdd.listeSuivi("mimie").get(i) + " ");
			}
			System.out.println("");
			
		System.out.println("--> Supprimer Abonnement : " + bdd.supprimerAbonnement("patoche", "mimie"));
		
		System.out.println("--> Création Abonnement : " + bdd.creerAbonnement("mimie", "patoche"));
		
		System.out.println("--> Création Abonnement : " + bdd.creerAbonnement("patoche", "mimie"));
		
		System.out.println("--> Liste gazouilli de mimie : " +bdd.listeGazouilli("mimie").toString());

		System.out.println("--> Liste gazouilli des abonnements de mimie : " +bdd.listeGazouilliAbonnements("mimie").toString());
		
		System.out.println("--> Nombre de gazouilli de patoche : " +bdd.nbGazouilliPourUnProfil("patoche"));
		
		System.out.println("--> Liste des profils : " +bdd.listeProfil().get(0).toString());

		

		//Pour ouvrir H2 il faut pointer sur le bon dossier:
		//C:\Users\landt\Dropbox\USB\MIAGE\M2\S9\Intergiciels pour la répartition\Projet_JMS\M2_JMS_proj\M2_JMS_proj_code\Projet_Twitter
		
		bdd.fermer();		
	}*/
	
}
