package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BddJDBC_EL_Porte {

	Connection conn;
	
	public BddJDBC_EL_Porte(String nomBD) {
		try {
		    Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
			
	        s.execute("create table IF NOT EXISTS Portes  ( " +
        			" idPorte INT NOT NULL PRIMARY KEY, " +
        			" libellePorte VARCHAR( 500 ) NOT NULL ," +
        			" idZone INT )");

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
			ResultSet rs = conn.getMetaData().getTables(null, null, "Portes", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Portes");
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
	
	public String creerPorte(String plibellePorte, String pidZone) {
		String idp;
		int id = 0;
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MAX(idPorte) from portes");
        	if (rs.next())
        	{
        		id = rs.getInt(1) + 1;
        	}
			rs = s.executeQuery("select libellePorte from portes WHERE libellePorte = '"+plibellePorte+"'");
			if (!rs.next())
			{
				s.executeUpdate("insert into portes (idPorte,libellePiece,idZone) values ("+id+", '"+plibellePorte+"', "+pidZone+")");
				idp = String.valueOf(id);
			}
			else
			{
				idp = "-2"; // le cas ou l'empreinte existe déjà
			}
	        return idp;
		} catch (SQLException e) {
			e.printStackTrace();
			idp = "-1";
			return idp;
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
			creerPorte("P1", "1");
		//journalisation 2
			creerPorte("P2", "2");	
	}
}
