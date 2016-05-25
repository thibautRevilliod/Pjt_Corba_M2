package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BddJDBC_EL_Empreinte {

	Connection conn;
	
	public BddJDBC_EL_Empreinte(String nomBD) {
		try {
		    Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+nomBD+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
			
        	s.execute("create table IF NOT EXISTS Empreintes  ( " +
        			" idEmpreinte INT NOT NULL PRIMARY KEY, " +
        			" empreinte VARCHAR( 500 ) UNIQUE, " +
        			" idSal INT NOT NULL UNIQUE )");
			
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
			ResultSet rs = conn.getMetaData().getTables(null, null, "Empreintes", null);
	        if (rs.next()) {
	        	// la table existe
	        	s.execute("drop table Empreintes");
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
	
	public String ajouterEmpreinte(String  pidSal, String pempreinte) {
		String ide = "";
		int id = 0;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select MAX(idEmpreinte) from empreintes");
        	if (rs.next())
        	{
        		id = rs.getInt(1) + 1;
        	}
			rs = s.executeQuery("select empreinte from empreintes WHERE empreinte = '"+pempreinte+"'");
			if (!rs.next())
			{
	        	s.executeUpdate("insert into Empreintes (idEmpreinte,empreinte,idSal) "
	        			+ "values ("+id+", '"+pempreinte+"', "+pidSal+")");
	        	ide = String.valueOf(id);
			}
			else
			{
				ide = "-2"; // le cas ou l'empreinte existe déjà
			}
	        return ide;
		} catch (SQLException e) {
			e.printStackTrace();
			ide = "-1";
			return ide;
		}
	}
	
	//TODO à supprimer
	public String getCorrespondance(String pEmpreinte) {
		String res = "";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal from Empreintes where empreinte = '"+pEmpreinte+"'");
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
	
	public boolean verifierCorrespondance(String pidSal, String pEmpreinte) {
		boolean res = false;
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal from Empreintes where empreinte = '"+pEmpreinte+"' AND idsal = "+pidSal+"");
    		if(rs.next())
    		{
    			res = true;
    		}
    		
        	return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
	}
	
	public String supprimerEmpreinte(String pIdSal) {
		String ide = "";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT idEmpreinte FROM Empreintes WHERE idSal = '"+pIdSal+"'");
        	if (rs.next())
        	{
        		s.executeUpdate("DELETE FROM Empreintes WHERE idSal = '"+pIdSal+"'");
        		ide = String.valueOf(pIdSal);
        	}
        	else
        	{
        		// Erreur : l'abonnement n'existe pas
        		ide = "-2";
        	}
        	return ide;
		} catch (SQLException e) {
			e.printStackTrace();
			ide = "-1";
			return ide;
		}
	}
	
	//TODO : Gérer plusieurs empreinte pour un salarié ? si oui, cette méthode fonctionne pas... !
	public String modifierEmpreinte(String pidSal, String pempreinte) {
		String id = "0";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select idSal from empreintes WHERE idSal = "+pidSal+"");
			if (rs.next())
			{
				s.executeUpdate("UPDATE empreintes SET empreinte = '"+pempreinte+"' WHERE idSal = "+pidSal+"");
			}
			else
			{
				id = "-2"; // le cas ou accreditation existe déjà
			}
	        return id;
		} catch (SQLException e) {
			e.printStackTrace();
			id = "-1";
			return id;
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
		//Empreinte 1
			ajouterEmpreinte("empreinte1", "1");	
		//Empreinte 2
			ajouterEmpreinte("empreinte2", "2");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BddJDBC_EL_Empreinte bddJDBC_EL_Empreinte = new BddJDBC_EL_Empreinte("BD_Empreinte");
		//bddJDBC_EL_Annuaire.init();
		
		bddJDBC_EL_Empreinte.init();
		try {
			bddJDBC_EL_Empreinte.fermer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}