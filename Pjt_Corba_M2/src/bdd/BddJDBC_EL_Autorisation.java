package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

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
        			" idZone VARCHAR( 4 ) NOT NULL PRIMARY KEY, " +
        			" libelleZone VARCHAR( 500 ) UNIQUE )");

        	s.execute("create table IF NOT EXISTS Accrediter  ( " +
        			" idSal VARCHAR( 4 ) NOT NULL, " +
        			" idZone VARCHAR( 4 ) NOT NULL, " +
        			" dateAccreditation date , " +
					" jourDebut TIMESTAMP , " +
        			" jourFin TIMESTAMP , " +
					" heureDebut TIMESTAMP , " +
					" heureFin TIMESTAMP , " +
					" PRIMARY KEY (idSal, idZone) , " +
					" FOREIGN KEY (idZone) REFERENCES Zones(idZone))");
	        
        	s.execute("create table IF NOT EXISTS Acceder  ( " +
        			" idSal VARCHAR( 4 ) NOT NULL, " +
        			" idZone VARCHAR( 4 ) NOT NULL, " +
        			" dateDdeAcces date, " +
					" statuAcces boolean, " +
					" jourEntree TIMESTAMP , " +
        			" jourSortie TIMESTAMP , " +
					" heureEntree TIMESTAMP , " +
					" heureSortie TIMESTAMP , " +
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
			ResultSet rs = conn.getMetaData().getTables(null, null, "Acceder", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Acceder");
	        	res = true;
	        } else {	
	        	res = false;
	        }
	        
	        rs = conn.getMetaData().getTables(null, null, "Accrediter", null);
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
	
	public int creerZone(String pidZone, String plibelleZone) {
		int id = -1;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idZone from Zones WHERE idZone = '"+pidZone+"'");
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Zones (idZone,libelleZone) values ('"+pidZone+"', '"+plibelleZone+"')");
			}
			else
			{
				id = -2; // le cas ou la zone existe déjà
			}
	        return id;
		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
		}
	}
	
	public int creerAccrediter(String pidSal, String pidZone, Date pdateAccreditation, Timestamp pjourDebut, Timestamp pjourFin, Timestamp pheureDebut,Timestamp pheureFin) {
		int id = -1;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select dateAccreditation from Accrediter WHERE idZone = '"+pidZone+"' AND idSal = '"+pidSal+"'");
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Accrediter (idSal,idZone,dateAccreditation,jourDebut,jourFin,heureDebut,heureFin) values ('"+pidSal+"', '"+pidZone+"', "+pdateAccreditation+", "+pjourDebut+","+pjourFin+","+pheureDebut+","+pheureFin+"");
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
	
	public int creerAcceder(String pidSal, String pidZone, Date pdateDdeAcces, Boolean pstatuAcces, Timestamp pjourEntree, Timestamp pjourSortie,Timestamp pheureEntree,Timestamp pheureSortie) {
		int id = -1;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select dateDdeAcces from Acceder WHERE idZone = '"+pidZone+"' AND idSal = '"+pidSal+"'");
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Acceder (idSal,idZone,dateDdeAcces,pstatuAcces,pjourEntree,pjourSortie,pheureEntree,pheureSortie) values ('"+pidSal+"', '"+pidZone+"', "+pdateDdeAcces+", "+pstatuAcces+","+pjourEntree+","+pjourSortie+","+pheureEntree+","+pheureSortie+"");
			}
			else
			{
				id = -2; // le cas ou l'Acceder existe déjà
			}
	        return id;
		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
		}
	}
	
	public int modifierAccreditation(String pidSal, String pidZone, Timestamp pjourDebut, Timestamp pjourFin, Timestamp pheureDebut,Timestamp pheureFin) {
		int id = -1;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal from Accrediter WHERE idZone = '"+pidZone+"' AND idSal = '"+pidSal+"'");
			if (rs.next())
			{
				s.executeUpdate("UPDATE Accrediter SET jourDebut = "+pjourDebut+" AND jourFin = "+pjourFin+" AND heureDebut = "+pheureDebut+" AND heureFin = "+pheureFin+" WHERE idZone = '"+pidZone+"' AND idSal = '"+pidSal+"'");
			}
			else
			{
				id = -2; // le cas ou accreditation existe déjà
			}
	        return id;
		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
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
    			res[i] = new InfoZone(rs.getString(1),rs.getString(2));
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
		creerZone("1", "Zone1");
		creerZone("2", "Zone2");
		creerZone("3", "Zone3");
		creerZone("4", "Zone4");	
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
