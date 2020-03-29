package it.polito.tdp.EsempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	
	public void run() {
		String jbdcURL ="jdbc:mysql://localhost/babs?user=root&password=ac14dg!";
		
		try {
			Connection conn = DriverManager.getConnection(jbdcURL);
			//SQL E PREPARED STATEMENT UNA VOLTA SOLA
			String sql="SELECT name FROM station WHERE landmark= ? "; //prima query

			PreparedStatement st= conn.prepareStatement(sql); //poi statement
			
			//SETSTRING E RESULT POSSONO ESSERE RIPETUTE MOLTE VOLTE
			st.setString(1, "Palo Alto"); //lo metto per definire il punto interrogativo di landmark
			ResultSet res= st.executeQuery();
			
			while(res.next()) { //finchè è vero il cursore è posizionato su una riga che esiste
				String nomeStazione= res.getString("name");
				System.out.println(nomeStazione);
			}
			
			st.close(); //-->chiudo solo se ho più statement
			
			//quando ho finito una interrogazione posso farne un'altra
			//Statement st2= conn.createStatement();
			
			conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		//FACTORY: creazione di un oggetto di una classe, senza conoscere il tipo della
		//classe (NON posso usare new)
		//uso un metodo fornito da un'altra classe che internamente farà new e conoscerà
		//il tipo di classe effettivo
	}
	
	public static void main (String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}

}
