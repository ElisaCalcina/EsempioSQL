package it.polito.tdp.EsempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.EsempioSQL.model.Station;

public class BabsDAO {
	//voglio avere informazioni su tutte le stazioni di parcheggio delle bici
	public List<Station> listStation(){ //station-->oggetto che trasferisce dati: è nel model
		List<Station> result = new ArrayList<Station>();
		
		String sql = "SELECT station_id, NAME, dockcount, landmark FROM station ORDER BY name";
			
		try {
			Connection conn = DBConnect.getConnection();

			PreparedStatement st= conn.prepareStatement(sql); 
			
			ResultSet res= st.executeQuery();
			
			while(res.next()) { 
				Station s= new Station(res.getInt("station_id"), 
						res.getString("name"), 
						res.getInt("dockCount"),
						res.getString("landmark"));
				result.add(s);
			}
			
			st.close(); 
						
			conn.close();
			
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
		return null;
	}
	
	public List<Station> listStationByLandMark(String landmark){
	List<Station> result = new ArrayList<Station>();
		
		String sql = "SELECT station_id, NAME, dockcount, landmark FROM station" + ""
				+ " WHERE landmark=? ORDER BY name";
	
		
		try {
			Connection conn = DBConnect.getConnection();

			PreparedStatement st= conn.prepareStatement(sql); 
			
			st.setString(1, landmark);
			ResultSet res= st.executeQuery();
			
			while(res.next()) { 
				Station s= new Station(res.getInt("station_id"), 
						res.getString("name"), 
						res.getInt("dockCount"),
						res.getString("landmark"));
				result.add(s);
			}
			
			st.close(); 
						
			conn.close();
			
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
		return null;
	}

}
